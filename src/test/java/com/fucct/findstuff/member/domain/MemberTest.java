package com.fucct.findstuff.member.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.fucct.findstuff.member.fixture.MemberFixture;

@DisplayName("Member 클래스")
class MemberTest {

    private Member member;

    @BeforeEach
    void setUp() {
        member = MemberFixture.createWithoutId();
    }

    @Nested
    @DisplayName("changeInfo 메소드는")
    class Describe_change_info {

        @Nested
        @DisplayName("만약 email, name, nickname, password가 주어지면")
        class Context_with_info {
            private final String givenEmail = MemberFixture.OTHER_EMAIL;
            private final String givenName = MemberFixture.OTHER_NAME;
            private final String givenNickname = MemberFixture.OTHER_NICKNAME;
            private final String givenPassword = MemberFixture.OTHER_PASSWORD;

            @Test
            @DisplayName("email을 수정한다")
            void email() {
                member.changeInfo(givenEmail, member.getName(), member.getNickname(),
                    member.getPassword());

                assertThat(member).extracting(Member::getEmail)
                    .isEqualTo(givenEmail);
            }

            @Test
            @DisplayName("name을 수정한다")
            void name() {
                member.changeInfo(member.getEmail(), givenName, member.getNickname(),
                    member.getPassword());

                assertThat(member).extracting(Member::getName)
                    .isEqualTo(givenName);
            }

            @Test
            @DisplayName("nickname을 수정한다")
            void nickname() {
                member.changeInfo(member.getEmail(), member.getName(), givenNickname,
                    member.getPassword());

                assertThat(member).extracting(Member::getNickname)
                    .isEqualTo(givenNickname);

            }

            @Test
            @DisplayName("password를 수정한다")
            void password() {
                member.changeInfo(member.getEmail(), member.getName(), member.getNickname(),
                    givenPassword);

                assertThat(member).extracting(Member::getPassword)
                    .isEqualTo(givenPassword);
            }
        }
    }
}
