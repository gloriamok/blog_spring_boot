package com.blog_spring_boot.blog_spring_boot.post;

import com.blog_spring_boot.blog_spring_boot.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}