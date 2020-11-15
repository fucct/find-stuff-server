package com.fucct.findstuff.login;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final Map<String, LoginApiService> loginApiServices;

    public AccessToken getAccessToken(LoginType type, String code) throws JsonProcessingException {
        LoginApiService loginApiService = loginApiServices.get(type.getLoginApiServiceName());
        AccessToken accessToken = loginApiService.getAccessToken(code);

        return accessToken;
    }
}
