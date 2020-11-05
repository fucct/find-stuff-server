package com.fucct.findstuff.article;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fucct.findstuff.comment.Comment;
import com.fucct.findstuff.comment.CommentFixture;

class ArticleTest {

    @DisplayName("Create article")
    @Test
    void createArticle() {
        assertThat(Article.builder().build()).isInstanceOf(Article.class);
    }

    @DisplayName("Modify title of article")
    @Test
    void changeTitle() {
        Article article = ArticleFixture.createWithoutId();
        assertThat(article).extracting(Article::getTitle)
            .isEqualTo(ArticleFixture.TITLE);
        assertThat(article).extracting(Article::getContent)
            .isEqualTo(ArticleFixture.CONTENT);

        article.modifyArticle(ArticleFixture.OTHER_TITLE, ArticleFixture.CONTENT);
        assertThat(article).extracting(Article::getTitle)
            .isEqualTo(ArticleFixture.OTHER_TITLE);
        assertThat(article).extracting(Article::getContent)
            .isEqualTo(ArticleFixture.CONTENT);
    }

    @DisplayName("Modify content of article")
    @Test
    void changeContent() {
        Article article = ArticleFixture.createWithoutId();
        assertThat(article).extracting(Article::getTitle)
            .isEqualTo(ArticleFixture.TITLE);
        assertThat(article).extracting(Article::getContent)
            .isEqualTo(ArticleFixture.CONTENT);

        article.modifyArticle(ArticleFixture.TITLE, ArticleFixture.OTHER_CONTENT);
        assertThat(article).extracting(Article::getTitle)
            .isEqualTo(ArticleFixture.TITLE);
        assertThat(article).extracting(Article::getContent)
            .isEqualTo(ArticleFixture.OTHER_CONTENT);
    }

    @DisplayName("Add comment to article")
    @Test
    void addComment() {
        Article article = ArticleFixture.createWithoutId();
        Comment comment = CommentFixture.createWithoutId();

        article.addComment(comment);

        assertThat(article).extracting(Article::getComments)
            .usingRecursiveComparison()
            .isEqualTo(Collections.singletonList(comment));
    }
}
