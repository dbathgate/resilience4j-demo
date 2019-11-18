package io.pivotal.resilience4jdemo.controller;

import io.pivotal.resilience4jdemo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping
    public ResponseEntity<String> getHello() {
        String hello = helloService.getHello();

        return ResponseEntity.ok(hello);
    }

    @GetMapping("/future")
    public CompletableFuture<String> getHelloFromFuture() {
        return helloService.getHelloFromFuture();
    }

    @GetMapping("/exception")
    public String getHelloException() {
        return helloService.getHelloException();
    }

    @GetMapping("/flux")
    public Flux<String> getHelloFlux() {
        return helloService.getHelloFlux();
    }
}
