package com.codeup.blogapp.controllers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import com.codeup.blogapp.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDoa;
    private final UserRepository userDoa;

    private final EmailService emailService;

    public PostController(PostRepository postDoa, UserRepository userDoa, EmailService emailService) {
        this.postDoa = postDoa;
        this.userDoa = userDoa;
        this.emailService = emailService;
    }
    @GetMapping("/posts")
    public String getPosts(Model model) {
        List<Post> posts = postDoa.findAll();
        for(Post post : posts){
            System.out.println(post.getUser().getEmail());
        }
        model.addAttribute("posts", posts);
        return "posts/show";
    }

    @GetMapping("/posts/{id}")
    public String getIndividualPost(@PathVariable long id, Model model) {
        Post currentPost = postDoa.getReferenceById(3L);
        model.addAttribute("post", currentPost);
        return "posts/post";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("post", new Post());
        return "posts/edit";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post) {
        User user = userDoa.getReferenceById(1L);
        String title = post.getTitle();
        String body = post.getBody();
        String email = user.getEmail();
        post.setUser(user);
        postDoa.save(post);
        System.out.println(user);
        return "redirect:/posts";
    }
}

