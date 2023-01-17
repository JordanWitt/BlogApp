package com.codeup.blogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
        @RequestMapping(path = "/post", method = RequestMethod.GET)
        @ResponseBody
        public String viewPost() {
            return " This is where the post index page would go";
        }

        @RequestMapping(path ="/post/{id}", method = RequestMethod.GET)
        @ResponseBody
        public String viewPostId(@PathVariable int id){
            return "This is a post with " + id + " as the id";
        }
        @RequestMapping(path ="/posts/create", method = RequestMethod.GET)
        @ResponseBody
        public String viewCreatePost(){
            return "This is a create page.";
        }
        @PostMapping(path ="/posts/create")
        @ResponseBody
        public String viewPostRequest(){
            return "This is a post request of the create page/ create a new post";
        }
}
