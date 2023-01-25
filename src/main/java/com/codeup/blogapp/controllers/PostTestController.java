package com.codeup.blogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostTestController {
    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        return "posts";
    }

    @GetMapping("/posts{id}")
    @ResponseBody
    public String indexId(@PathVariable long id){
        return "posts/" + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String indexCreate(){
        return "posts";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String indexShowCreate(){
        return "posts/create";
    }
}
