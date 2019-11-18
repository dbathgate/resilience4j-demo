package io.pivotal.resilience4jdemo.service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.pivotal.resilience4jdemo.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.concurrent.CompletableFuture;

@Service
public class HelloService {

    @Autowired
    private HelloDao helloDao;

    public String getHello() {
        return helloDao.getHello();
    }

    public CompletableFuture<String> getHelloFromFuture() {
        return helloDao.getHelloFuture();
    }

    public String getHelloException() {
        return helloDao.getHelloException();
    }

    public Flux<String> getHelloFlux() {
        return helloDao.getHelloFlux();
    }
}
