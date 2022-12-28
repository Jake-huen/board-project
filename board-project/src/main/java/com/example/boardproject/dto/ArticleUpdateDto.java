package com.example.boardproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.example.boardproject.domain.Article} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUpdateDto {
    private String title;
    private String content;
    private String hashtag;

    public static ArticleUpdateDto of(String title, String content, String hashtag) {
        return new ArticleUpdateDto(title,content,hashtag);
    }
}