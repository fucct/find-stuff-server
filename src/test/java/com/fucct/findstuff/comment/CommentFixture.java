package com.fucct.findstuff.comment;

public class CommentFixture {
    public static final String CONTENT = "Hello Comment";
    public static final String OTHER_CONTENT = "안녕 댓글";

    public static Comment createWithoutId() {
        return Comment.builder()
            .content(CONTENT)
            .build();
    }
}
