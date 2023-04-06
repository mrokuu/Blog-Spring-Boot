package com.blog.mapper;

import com.blog.dto.PostDto;
import com.blog.entity.Post;

public class PostMapper {

    // conver PostEntity to PostDto
    public PostDto mapToDto(Post post ){
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createOn(post.getCreatedOn())
                .updateOn(post.getUpdatedOn())
                .build();
    }

//convert postDto to PostEntity
    public Post mapToPost(PostDto postDto){
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .url(postDto.getUrl())
                .shortDescription(postDto.getShortDescription())
                .createdOn(postDto.getCreateOn())
                .updatedOn(postDto.getUpdateOn())
                .build();
    }
}
