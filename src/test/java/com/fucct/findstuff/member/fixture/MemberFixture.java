package com.fucct.findstuff.member.fixture;

import com.fucct.findstuff.member.domain.Member;
import com.fucct.findstuff.member.domain.MemberType;

public class MemberFixture {

    public static final MemberType MEMBER_TYPE = MemberType.BASIC;
    public static final String PASSWORD = "1234";
    public static final String NICKNAME = "creamheroes";
    public static final String NAME = "dd";
    public static final String EMAIL = "dd@email.com";

    public static Member createWithId(long id) {
        return Member.builder()
            .id(id)
            .email(EMAIL)
            .name(NAME)
            .nickname(NICKNAME)
            .password(PASSWORD)
            .memberType(MEMBER_TYPE)
            .build();
    }
}
