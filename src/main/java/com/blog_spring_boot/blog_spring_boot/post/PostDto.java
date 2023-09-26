package com.blog_spring_boot.blog_spring_boot.post;

import com.blog_spring_boot.blog_spring_boot.comment.CommentDto;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private Integer id;
    private String title;
    private String description;
    private String content;
    private Set<CommentDto> commentSet;
}
