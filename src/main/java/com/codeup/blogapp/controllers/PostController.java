package com.codeup.blogapp.controllers;
import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDoa;

    private final UserRepository userDoa;

    public PostController(PostRepository postDoa, UserRepository userDoa){
        this.postDoa = postDoa; this.userDoa = userDoa;
    }

    @GetMapping("/posts")
    public String getPosts(Model model){
        List<Post> posts = postDoa.findAll();
        model.addAttribute("posts", posts);
        return "posts/show";
    }

    @GetMapping("/posts/{id}")
    public String getIndividualPost(@PathVariable long id, Model model){
        Post currentPost = postDoa.getReferenceById(1L);
        model.addAttribute("post", currentPost);
        return "posts/index";
    }
    @GetMapping("/create")
    public String createPost() {
        return "posts/create";
    }
}
