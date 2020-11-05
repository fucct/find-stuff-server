package com.fucct.findstuff.member.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @DisplayName("Save Member")
    @Test
    void save() {
        final Member member = new Member();
        assertThat(memberRepository.save(member))
            .extracting(Member::getId)
            .isEqualTo(1L);
    }
}
