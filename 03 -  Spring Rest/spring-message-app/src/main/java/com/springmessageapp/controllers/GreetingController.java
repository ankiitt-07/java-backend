package com.springmessageapp.controllers;

import com.springmessageapp.entities.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping()
    public ResponseEntity<Greeting> getGreeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        return new ResponseEntity<>(
                new Greeting(counter.incrementAndGet(), String.format(template, name)),
                HttpStatus.OK
        );
    }
}
