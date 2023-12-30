package springMSA.gateway.filter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.OrderedGatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static org.springframework.core.Ordered.*;
import static springMSA.gateway.filter.LoggingFilter.Config;

@Slf4j
@Component
public class LoggingFilter extends AbstractGatewayFilterFactory<Config> {

    public LoggingFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        GatewayFilter filter = new OrderedGatewayFilter((exchange,chain)-> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("LOGGING baseMessage {} ", config.getBaseMessage());

            if(config.isPreLogger()) {
                log.info("LOGGING filter request id = {}", request.getId());
            }

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if(config.isPostLogger()) {
                    log.info("LOGGING POST filter : response code={}", response.getStatusCode());
                }
            }));
        }, LOWEST_PRECEDENCE);
        //Ordered.HIGHEST_PRECEDENCE 우선 순위를 나타내는 것, 가장 높은 순서. 즉, 가장 먼저 실행이 된다 Global보다 더

        return filter;
    }


    @Data
    protected static class Config {
        private String baseMessage;
        private boolean preLogger;
        private boolean postLogger;

    }

}
