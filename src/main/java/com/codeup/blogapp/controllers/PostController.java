package com.codeup.blogapp.controllers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import com.codeup.blogapp.service.EmailService;
import com.codeup.blogapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    public  PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String getPosts(Model model){
        List<Post> ads = postService.getAllPosts();
        model.addAttribute("posts", ads);
        return "posts/show";
    }

    @GetMapping("/posts/{id}")
    public String getIndividualPost(@PathVariable long id, Model model){
        Post currentPost = postService.getPost(id);
        model.addAttribute("post", currentPost);
        return "posts/post";
    }

    @GetMapping("/ads/create")
    public String createForm(Model model){
        model.addAttribute("adToCreate", new Post());
        return "posts/create";
    }

    @PostMapping("/ads/create")
    public String createAd(@ModelAttribute Post createdAd){
        postService.create(createdAd);
        return "redirect:/posts";
    }
}

