package com.blog.service;

import com.blog.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();
    void createPost(PostDto postDto);
}
