package com.codeup.blogapp.controllers;
import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import com.codeup.blogapp.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDoa;

    private final UserRepository userDoa;

//    private final EmailService emailService;

    private PostService postService;

    public PostController(PostRepository postDoa, UserRepository userDoa, PostService postService){
        this.postDoa = postDoa;
        this.userDoa = userDoa;
//        this.emailService = emailService;
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String getPosts(Model model){
        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);
        return "posts/show";
    }

    @GetMapping("/posts/{id}")
    public String getIndividualPost(@PathVariable long id, Model model){
        Post currentPost = postDoa.getReferenceById(id);
        model.addAttribute("post", currentPost);
        return "posts/post";
    }
    @GetMapping ("/posts/create")
    public String createAdPage(){
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String create(@ModelAttribute Post post) {
        User user = userDoa.getReferenceById(1L);
        post.setUser(user);
        postDoa.save(post);
        return "redirect:/posts";
    }
}

