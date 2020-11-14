package com.fucct.findstuff.login;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginApiService loginApiService;

    public String getAccessToken(String code) throws JsonProcessingException {
        return loginApiService.getAccessToken(code).getAccessToken();
    }
}
