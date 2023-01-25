package com.codeup.blogapp.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Random;

@Controller
public class HomeController {
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
    @GetMapping("/home")
    public String welcome() {
        return "home";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }
    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", "Welcome " + name + "!");
        return "join";
    }

}
