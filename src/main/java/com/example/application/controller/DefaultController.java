package com.example.application.controller;

import com.example.application.processing.Processing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DefaultController {
    private Processing processing = new Processing();

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
        model.addAttribute("list", processing.getLinks("java"));
        return "/topicsPages/java";
    }

    @GetMapping("/spring")
    public String spring(Model model) {
        model.addAttribute("list", processing.getLinks("spring"));
        return "/topicsPages/spring";
    }

    @GetMapping("/spring_boot")
    public String spring_boot(Model model) {
        model.addAttribute("list", processing.getLinks("spring_boot"));
        return "/topicsPages/spring_boot";
    }

    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        model.addAttribute("list", processing.getLinks("thymeleaf"));
        return "/topicsPages/thymeleaf";
    }

    @GetMapping("/addLink")
    public String addLink(Model model, HttpServletRequest request) {
        try {
            String topic = request.getParameter("topic").trim();
            String link = request.getParameter("link").trim();
            if (link.isEmpty()){
                model.addAttribute("errorMessage", "You are trying to add a blank link");
                return "/addLink";
            }else {
                processing.setLinks(topic,link);
                return "redirect:/home";
            }
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("errorMessage", "You didn't choose a topic ");
            return "/addLink";
        }
    }
}
