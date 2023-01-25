package com.codeup.blogapp.service;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service("PostService")
public class PostService {

    private final PostRepository postDoa;

    private final UserRepository userDoa;

    private final EmailService emailService;


    public PostService(PostRepository postDoa, UserRepository userDoa, EmailService emailService){
        this.postDoa = postDoa;
        this.userDoa = userDoa;
        this.emailService = emailService;

    }
    public List <Post> getAllPosts(){
        for(Post post: postDoa.findAll()){
            System.out.println("Username: " + post.getUser().getUsername());
            System.out.println("Title: " + post.getTitle());
            System.out.println("Body: " + post.getBody());
            }
        return postDoa.findAll();
    }
    public void create(Post post){
        User user = userDoa.getReferenceById(1L);
        post.setUser(user);
        emailService.preparedAndSend(post, post.getTitle(), post.getBody());
        postDoa.save(post);

    }
}
