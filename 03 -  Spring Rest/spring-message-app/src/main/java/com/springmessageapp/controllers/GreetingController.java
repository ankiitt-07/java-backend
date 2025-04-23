package com.springmessageapp.controllers;

import com.springmessageapp.entities.Greeting;
import com.springmessageapp.services.GreetingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/simple")
    public ResponseEntity<Greeting> simpleGreeting() {
        return new ResponseEntity<>(greetingService.getSimpleGreeting(), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Greeting>> getGreeting(
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "lastName", defaultValue = "") String lastName
    ) {
        return new ResponseEntity<>(
                greetingService.getGreeting(),
                HttpStatus.OK
        );
    }
    @PostMapping()
    public ResponseEntity<Greeting> addGreeting(
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "lastName", defaultValue = "") String lastName
    ) {
        return new ResponseEntity<>(greetingService.addGreeting(firstName, lastName), HttpStatus.OK);
    }
}
