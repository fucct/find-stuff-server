package com.fucct.findstuff.comment;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Comment 클래스")
class CommentTest {

    private Comment comment;

    @BeforeEach
    void setUp() {
        comment = CommentFixture.createWithoutId();
    }

    @Nested
    @DisplayName("changeContent 메소드는")
    class Describe_change_content{

        @Nested
        @DisplayName("Content가 주어진다면")
        class Context_with_content {
            private final String givenContent = CommentFixture.OTHER_CONTENT;

            @Test
            @DisplayName("Comment content를 수정한다")
            void it_changes_comment_content() {
                comment.changeContent(givenContent);

                assertThat(comment).extracting(Comment::getContent)
                    .isEqualTo(givenContent);
            }
        }
    }
}
