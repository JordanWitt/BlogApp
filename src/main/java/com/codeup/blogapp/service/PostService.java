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


    public PostService(PostRepository postDoa, UserRepository userDoa){
        this.postDoa = postDoa;
        this.userDoa = userDoa;

    }
    public List <Post> getPosts(){
        return postDoa.findAll();
    }
    public void create(Post post){
        User user = userDoa.getReferenceById(1L);
        post.setUser(user);

    }
}
