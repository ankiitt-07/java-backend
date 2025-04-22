package com.intro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/web")
    public String web() {
        return "hello";
    }

    @GetMapping("/web/message")
    public String message(Model model) {
        model.addAttribute("message","Hello from BridgeLabz");
        return "message";
    }

}
