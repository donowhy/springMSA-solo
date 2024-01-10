package springMSA.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


import static springMSA.gateway.filter.CustomFilter.*;

@Slf4j
@Component
public class CustomFilter extends AbstractGatewayFilterFactory<Config> {

    public CustomFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("CUSTOM PRE filter : request ID={}", request.getId());

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("CUSTOM POST filter : response code={}", response.getStatusCode());
            }));

        };
    }


    public static class Config {

    }

}
