package uz.writer.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class CustomWebFilter implements WebFilter {

    private final static Logger log = LoggerFactory.getLogger(CustomWebFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        long startTime = System.currentTimeMillis();

        return chain.filter(exchange)
                .doFinally(signalType -> {
                    long totalTime = System.currentTimeMillis() - startTime;
                    exchange.getAttributes().put("totalTime", totalTime);
                    StringBuilder logMessage = new StringBuilder();
                    logMessage.append("Took: ").append(totalTime).append(" ms").append("\t");
                    logMessage.append("method: ").append(exchange.getRequest().getMethod()).append("\t");
                    logMessage.append("uri: ").append(exchange.getRequest().getPath()).append("\t");
                    logMessage.append("status: ").append(exchange.getResponse().getStatusCode()).append("\t");
                    logMessage.append("remoteAddress: ").append(exchange.getRequest().getRemoteAddress()).append("\t");

                    log.info(logMessage.toString());
                });
    }

}
