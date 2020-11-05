package com.fucct.findstuff.comment;

import com.fucct.findstuff.member.fixture.MemberFixture;

public class CommentFixture {
    public static final String CONTENT = "Hello Comment";
    public static final String OTHER_CONTENT = "안녕 댓글";

    public static Comment createWithoutId() {
        return Comment.builder()
            .content(CONTENT)
            .member(MemberFixture.createWithId(1L))
            .build();
    }
}
