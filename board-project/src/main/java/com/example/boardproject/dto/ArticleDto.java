package com.example.boardproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.example.boardproject.domain.Article} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private LocalDateTime createdAt;
    private String createdBy;
    private String title;
    private String content;
    private String hashtag;

    public static ArticleDto of(LocalDateTime now, String taeheon, String title, String content, String hashtag) {
        return new ArticleDto(now,taeheon,title,content,hashtag);
    }
}