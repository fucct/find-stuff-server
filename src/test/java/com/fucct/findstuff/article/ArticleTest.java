package com.fucct.findstuff.article;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.fucct.findstuff.comment.Comment;
import com.fucct.findstuff.comment.CommentFixture;
import com.fucct.findstuff.common.ImageUrl;
import com.fucct.findstuff.member.domain.Member;
import com.fucct.findstuff.member.fixture.MemberFixture;

@DisplayName("Article 클래스")
class ArticleTest {

    private Article article;

    @BeforeEach
    void setUp() {
        article = ArticleFixture.createWithoutId();
    }

    @Nested
    @DisplayName("Builder.build 메소드는")
    class Describe_builder {
        private final String givenTitle = ArticleFixture.TITLE;
        private final String givenContent = ArticleFixture.CONTENT;
        private final List<ImageUrl> urls = Lists.newArrayList(ArticleFixture.IMAGE_URL);
        private final Member givenMember = MemberFixture.createWithId(1L);

        @Nested
        @DisplayName("만약 제목, 내용, image url 목록, 사용자가 주어진다면")
        class Context_with_contents {
            @Test
            @DisplayName("Article을 생성하여 리턴한다")
            void it_returns_article() {
                Article article = Article.builder()
                    .title(givenTitle)
                    .content(givenContent)
                    .images(urls)
                    .member(givenMember)
                    .build();

                assertThat(article).isInstanceOf(Article.class);
            }
        }
    }

    @Nested
    @DisplayName("modifyArticle 메소드는")
    class Describe_modify_article {
        private final String givenNewTitle = ArticleFixture.OTHER_TITLE;
        private final String givenNewContent = ArticleFixture.OTHER_CONTENT;
        private final List<ImageUrl> newUrls = Lists.newArrayList(ArticleFixture.OTHER_IMAGE_URL);
        private final Member givenMember = MemberFixture.createWithId(1L);

        @Nested
        @DisplayName("만약 제목, 내용, image url 목록이 주어진다면")
        class Context_with_contents {

            @Test
            @DisplayName("Article의 제목을 수정한다")
            void it_changes_article_title() {
                article.modifyArticle(givenNewTitle, article.getContent(), article.getImages());

                assertThat(article)
                    .extracting(Article::getTitle).isEqualTo(givenNewTitle);
            }

            @Test
            @DisplayName("Article의 내용을 수정한다")
            void it_changes_article_content() {
                article.modifyArticle(article.getTitle(), givenNewContent, article.getImages());

                assertThat(article)
                    .extracting(Article::getContent).isEqualTo(givenNewContent);
            }

            @Test
            @DisplayName("Article의 이미지 url을 수정한다")
            void it_changes_article_image_urls() {
                article.modifyArticle(article.getTitle(), article.getContent(), newUrls);

                assertThat(article)
                    .extracting(Article::getImages)
                    .usingRecursiveComparison()
                    .isEqualTo(newUrls);
            }
        }
    }

    @Nested
    @DisplayName("addComment 메소드는")
    class Describe_addComment {
        private final Comment comment = CommentFixture.createWithoutId();

        @Nested
        @DisplayName("만약 Comment가 주어진다면")
        class Context_with_comment {

            @Test
            @DisplayName("Article에 Comment를 추가한다")
            void it_returns_article() {
                article.addComment(comment);

                assertThat(article.getComments()).containsExactly(comment);
            }
        }
    }

}
