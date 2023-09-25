package com.blog_spring_boot.blog_spring_boot.post;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(Integer id);
    PostDto updatePost(PostDto postDto, Integer id);
    String deletePostById(Integer id);
}
