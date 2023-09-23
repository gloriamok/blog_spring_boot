package com.blog_spring_boot.blog_spring_boot.post;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(Integer id);
    PostDto updatePost(PostDto postDto, Integer id);
    String deletePostById(Integer id);
}
