package com.codeup.blogapp.repositories;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Post, Long> {

    User findByUsername(String username);

    Post findByEmail(String email);
}
