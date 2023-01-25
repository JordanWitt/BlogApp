package com.codeup.blogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public String hello(){
        return "test";
    }

    @GetMapping("/test{name}")
    @ResponseBody
    public String sayHelloTest(@PathVariable String name){
        return name;
    }
    @RequestMapping(path = "/add/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }
    @GetMapping("/")
    @ResponseBody
    public String landingTest(){
        return "This is the testing page";
    }
}
