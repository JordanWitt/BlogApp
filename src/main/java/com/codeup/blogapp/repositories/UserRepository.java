package com.codeup.blogapp.repositories;

import com.codeup.blogapp.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Post, Long> {

    Post findByUsername(String username);

    Post findByEmail(String email);
}
