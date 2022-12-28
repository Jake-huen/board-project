package com.example.boardproject.service;

import com.example.boardproject.domain.Article;
import com.example.boardproject.domain.ArticleComment;
import com.example.boardproject.dto.ArticleCommentUpdateDto;
import com.example.boardproject.dto.ArticleDto;
import com.example.boardproject.dto.ArticleUpdateDto;
import com.example.boardproject.repository.ArticleCommentRepository;
import com.example.boardproject.repository.ArticleRepository;
import com.example.boardproject.dto.ArticleCommentDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService sut;

    @Mock private ArticleCommentRepository articleCommentRepository;
    @Mock private ArticleRepository articleRepository;


    @DisplayName("게시글 ID로 조회하면, 해당하는 댓글 리스트를 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticleComments_thenReturnsArticleComments() {
        // given
        Long articleId = 1L;
        given(articleRepository.findById(articleId)).willReturn(Optional.of(
                Article.of("title","content","hashtag"))
        );

        // when
        List<ArticleCommentDto> articleComments = sut.searchArticleComment(1L);

        // then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);

    }

    @DisplayName("댓글 정보를 입력하면, 댓글을 저장한다.")
    @Test
    void givenArticleComments_whenSSavingArticleComments_thenSavingArticleComments() {
        // given
        ArticleCommentDto dto = ArticleCommentDto.of(LocalDateTime.now(),"Taeheon",LocalDateTime.now(),"Taeheon","content");
        given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        // when
        sut.saveArticleComment(dto);

        // then
        then(articleCommentRepository).should().save(any(ArticleComment.class));
    }

    @DisplayName("댓글의 ID와 수정정보를 입력하면, 댓글을 수정한다")
    @Test
    void givenArticleCommentIdAndModifiedInfo_whenUpdatingArticleComment_thenUpdatesArticleComment() {
        // given
        ArticleCommentUpdateDto dto = ArticleCommentUpdateDto.of( "content");
        given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        // when
        sut.updateArticleComment(1L, dto);

        // then
        then(articleCommentRepository).should().save(any(ArticleComment.class));
    }

    @DisplayName("댓글의 ID를 입력하면, 댓글을 삭제한다")
    @Test
    void givenArticleCommentId_whenDeleteArticleComment_thenDeletesArticleComment() {
        // given
        willDoNothing().given(articleCommentRepository).delete(any(ArticleComment.class));

        // when
        sut.deleteArticleComment(1L);

        // then
        then(articleCommentRepository).should().delete(any(ArticleComment.class));
    }
}