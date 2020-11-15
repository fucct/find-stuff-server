package com.fucct.findstuff.login;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class LoginTypeTest {

    ObjectMapper objectMapper;

    @Test
    void name() throws JsonProcessingException {
        objectMapper = new ObjectMapper();

        LoginType github = objectMapper.readValue("{ \"loginType\": \"github\" }", LoginType.class);
        assertThat(github).isEqualTo(LoginType.GITHUB);
    }
}
