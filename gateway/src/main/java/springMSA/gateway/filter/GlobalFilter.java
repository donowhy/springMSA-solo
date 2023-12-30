package springMSA.gateway.filter;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static springMSA.gateway.filter.GlobalFilter.Config;

@Slf4j
@Component
public class GlobalFilter extends AbstractGatewayFilterFactory<Config> {

    public GlobalFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("GLOBAL baseMessage {} ", config.getBaseMessage());

            if(config.isPreLogger()) {
                log.info("GLOBAL filter request id = {}", request.getId());
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if(config.isPostLogger()) {
                    log.info("GLOBAL POST filter : response code={}", response.getStatusCode());
                }
            }));

        };
    }


    @Data
    protected static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;

    }

}
