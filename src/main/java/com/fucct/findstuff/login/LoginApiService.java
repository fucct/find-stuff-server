package com.fucct.findstuff.login;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface LoginApiService {
    AccessToken getAccessToken(String code) throws JsonProcessingException;
}
