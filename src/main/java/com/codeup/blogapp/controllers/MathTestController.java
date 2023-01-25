package com.codeup.blogapp.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathTestController {

    @GetMapping("/add/{a}/and/{b}")
    @ResponseBody
    public String addNumbers(@PathVariable int b, @PathVariable int a){
        return a + " plus " + b + " is equal to " + (a + b) ;
    }
    @GetMapping("/minus/{a}/and/{b}")
    @ResponseBody
    public String minusNumbers(@PathVariable int b, @PathVariable int a){
        return a + " minus " + b + " is equal to " + (a - b) ;
    }
    @GetMapping("/multiply/{a}/and/{b}")
    @ResponseBody
    public String multiplyNumbers(@PathVariable int b, @PathVariable int a){
        return a + " times " + b + " is equal to " + (a * b) ;
    }
    @GetMapping("/divide/{a}/and/{b}")
    @ResponseBody
    public String divideNumbers(@PathVariable int b, @PathVariable int a){
        return a + " divided by " + b + " is equal to " + (a/b) ;
    }
}
