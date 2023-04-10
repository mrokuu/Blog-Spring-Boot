package com.blog.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    @NotEmpty
    private String title;
    private String url;
    @NotEmpty
    private String content;
    @NotEmpty
    private String shortDescription;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;

    private Set<CommentDto> comments;
}
