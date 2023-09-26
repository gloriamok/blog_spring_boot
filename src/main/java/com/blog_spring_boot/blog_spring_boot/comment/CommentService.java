package com.blog_spring_boot.blog_spring_boot.comment;

import java.util.List;

public interface CommentService {
    CommentDto createComment(Integer postId, CommentDto commentDto);
    List<CommentDto> getCommentsByPostId(Integer postId);

    CommentDto getCommentById(Integer postId, Integer commentId);

    CommentDto updateComment(Integer postId, Integer commentId, CommentDto commentDto);

    String deleteComment(Integer postId, Integer commentId);
}
