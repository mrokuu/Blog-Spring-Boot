package com.blog.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
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
    private LocalDate createdOn;
    private LocalDate updateOn;
}
