package com.circuit.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/circuit")
@RestController
public class CircuitController {

    private final String DEFAULT_NAME = "hgsssss";
    private final String FALLBACK_DEFAULT = "helloFallback";



    @CircuitBreaker(name = DEFAULT_NAME, fallbackMethod = FALLBACK_DEFAULT)
    @GetMapping
    public String getVenhSupport(String param) {
        String url = "http://localhost:9990/user/circuit_test";

        return new RestTemplate().getForObject(url, String.class);
    }

    private String helloFallback(String name, Throwable t) {
      log.info("e..", t);
        return "ERROR 이시다.";
    }
}
