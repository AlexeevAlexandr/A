package com.example.application.controller;

import com.example.application.processing.Processing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/topics")
    public String topics() {
        return "/topics";
    }

    @GetMapping("/java")
    public String java(Model model) {
        model.addAttribute("list", new Processing().getLinks());
        return "/topicsPages/java";
    }

    @GetMapping("/spring")
    public String spring() {
        return "/topicsPages/spring";
    }

    @GetMapping("/spring_boot")
    public String spring_boot() {
        return "/topicsPages/spring_boot";
    }

    @GetMapping("/thymeleaf")
    public String thymeleaf() {
        return "/topicsPages/thymeleaf";
    }
}
