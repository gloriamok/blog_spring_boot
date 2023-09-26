package com.blog_spring_boot.blog_spring_boot.post;

import com.blog_spring_boot.blog_spring_boot.comment.CommentDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private Integer id;
    @NotEmpty
    @Size(min = 2)
    private String title;
    @NotEmpty
    @Size(min = 10)
    private String description;
    @NotEmpty
    private String content;
    private Set<CommentDto> commentSet;
}
