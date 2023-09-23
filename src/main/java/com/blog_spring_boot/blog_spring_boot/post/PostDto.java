package com.blog_spring_boot.blog_spring_boot.post;

import lombok.Data;

@Data
public class PostDto {
    private Integer id;
    private String title;
    private String description;
    private String content;
}
