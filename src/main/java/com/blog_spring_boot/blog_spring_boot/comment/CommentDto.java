package com.blog_spring_boot.blog_spring_boot.comment;

import lombok.Data;

@Data
public class CommentDto {
    private Integer id;
    private String name;
    private String email;
    private String body;
}
