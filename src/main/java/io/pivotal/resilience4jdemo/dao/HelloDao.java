package io.pivotal.resilience4jdemo.dao;

import reactor.core.publisher.Flux;

import java.util.concurrent.CompletableFuture;

public interface HelloDao {
    String getHello();

    CompletableFuture<String> getHelloFuture();

    String getHelloException();

    Flux<String> getHelloFlux();
}
