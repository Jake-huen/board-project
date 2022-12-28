package com.example.boardproject.service;

import com.example.boardproject.domain.Article;
import com.example.boardproject.domain.type.SearchType;
import com.example.boardproject.repository.ArticleRepository;
import com.example.boardproject.dto.ArticleDto;
import com.example.boardproject.dto.ArticleUpdateDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

// SpringBoot Slice Test를 사용하지 않고 작성하는 방법
// 테스트는 가벼울수록 좋음
// mockito

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;

//    홈 버튼 -> 게시판 페이지로 리다이렉션
//    정렬 기능

    @DisplayName("게시글을 검색하면 게시글 리스트를 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnArticleList () {
        // given
        // 5개 중 하나만 가지고 검색하도록 해보자

        // when
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); // 제목, 본문, ID, 닉네임, 해시태그

        // then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnArticle () {
        // given
        // 5개 중 하나만 가지고 검색하도록 해보자

        // when
        ArticleDto articles = sut.searchArticle(1L); // 제목, 본문, ID, 닉네임, 해시태그

        // then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        // given
        ArticleDto dto = ArticleDto.of(LocalDateTime.now(), "Taeheon", "title", "content", "hashtag");
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        sut.saveArticle(dto);

        // then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글의 ID와 수정정보를 입력하면, 게시글을 수정한다")
    @Test
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdatesArticle() {
        // given
        ArticleUpdateDto dto = ArticleUpdateDto.of( "title", "content", "hashtag");
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        sut.updateArticle(1L, dto);

        // then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글의 ID를 입력하면, 게시글을 삭제한다")
    @Test
    void givenArticleId_whenDeleteArticle_thenDeletesArticle() {
        // given
        willDoNothing().given(articleRepository).delete(any(Article.class));

        // when
        sut.deleteArticle(1L);

        // then
        then(articleRepository).should().delete(any(Article.class));
    }


}