package com.fucct.findstuff.login;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginApiService loginApiService;

    public String getAccessToken(String code) {
        return loginApiService.getAccessToken(code);
    }
}
