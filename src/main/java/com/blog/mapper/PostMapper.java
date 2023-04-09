package com.blog.mapper;

import com.blog.dto.PostDto;
import com.blog.entity.Post;

import java.util.stream.Collectors;

public class PostMapper {

    // conver PostEntity to PostDto
    public static PostDto mapToDto(Post post){
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updateOn(post.getUpdatedOn())
                .comments(post.getComments().stream()
                        .map((comment) -> CommentMapper.mapToCommentDto(comment))
                        .collect(Collectors.toSet()))
                .build();
    }

//convert postDto to PostEntity
    public static Post mapToPost(PostDto postDto){
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .url(postDto.getUrl())
                .shortDescription(postDto.getShortDescription())
                .createdOn(postDto.getCreatedOn())
                .updatedOn(postDto.getUpdateOn())
                .build();
    }
}
