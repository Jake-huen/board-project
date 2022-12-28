package com.example.boardproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.example.boardproject.domain.ArticleComment} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCommentUpdateDto implements Serializable {
    private String content;

    public static ArticleCommentUpdateDto of(String content) {
        return new ArticleCommentUpdateDto(content);
    }
}