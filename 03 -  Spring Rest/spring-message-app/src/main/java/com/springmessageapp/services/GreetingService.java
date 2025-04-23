package com.springmessageapp.services;


import org.springframework.stereotype.Service;
import com.springmessageapp.entities.Greeting;

@Service
public class GreetingService {
    public Greeting getSimpleGreeting(){
        return new Greeting("Hello World");
    }

    public Greeting getGreeting(String firstName, String lastName) {
        return new Greeting(("Hello " + firstName + " " + lastName).trim());
    }
}

