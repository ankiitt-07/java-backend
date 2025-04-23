package com.springmessageapp.controllers;

import com.springmessageapp.entities.Greeting;
import com.springmessageapp.services.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/simple")
    public ResponseEntity<String> simpleGreeting() {
        return new ResponseEntity<>(greetingService.getSimpleGreeting(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Greeting> getGreeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new ResponseEntity<>(
                new Greeting(counter.incrementAndGet(), String.format(template, name)),
                HttpStatus.OK
        );
    }
}
