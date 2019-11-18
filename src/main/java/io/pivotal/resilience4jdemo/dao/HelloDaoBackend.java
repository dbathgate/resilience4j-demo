package io.pivotal.resilience4jdemo.dao;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import reactor.core.publisher.Flux;

import java.util.concurrent.CompletableFuture;

@Component
public class HelloDaoBackend  implements HelloDao {

    @Bulkhead(name="helloBulkhead")
    @CircuitBreaker(name="helloCircuitBreaker")
    @Override
    public String getHello() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello world\n";
    }

    @Bulkhead(name="helloThreadBulkhead", type = Bulkhead.Type.THREADPOOL)
    @Override
    public CompletableFuture<String> getHelloFuture() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture("Hello world from the future\n");
    }

    @CircuitBreaker(name="helloCircuitBreaker")
    @Override
    public String getHelloException() {
        throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "This is going to fail");
    }

    @RateLimiter(name="helloRateLimiter")
    @Override
    public Flux<String> getHelloFlux() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Flux.just("Hello Flux\n");
    }
}
