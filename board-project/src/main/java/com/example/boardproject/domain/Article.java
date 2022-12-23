package com.example.boardproject.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

//Field 구성
@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class Article extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Column(nullable=false) private String title; // 제목
    @Setter @Column(nullable = false) private String content; // 본문
    @Setter private String hashtag; // 해시태그

    // One to many 관계 : Article, ArticleComment
    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL)
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    // meta data -> MappedSuperclass로 Aritcle_comment랑 묶음.

    // 모든 JPA entity들은 hibernate 구현체를 사용하는 기준으로
    // 설명될 때 기본 생성자가 있어야 한다.
    protected Article() {} // 굳이 public 할 필요는 없다. 코드밖에서 new로 생성못하게
    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of(String title, String content, String hashtag) {
        return new Article(title,content,hashtag);
    }

    // Equals와 hashCode를 lombok으로도 구현할 수 있다.
    // but, Entity에서는 독특한 방법으로 해야 한다.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false; //article인지 확인
        Article article = (Article) o; // 이부분이 보일러 플레이팅 아닌가
        return id !=null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
