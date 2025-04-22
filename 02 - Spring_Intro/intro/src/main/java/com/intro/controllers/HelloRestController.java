package com.intro.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    private static final Logger log = LoggerFactory.getLogger(HelloRestController.class);

    @GetMapping("/rest")
    public String hello() {
        log.info("handling rest request to \"/rest\"");
        return "hello world from rest controller";
    }
}
