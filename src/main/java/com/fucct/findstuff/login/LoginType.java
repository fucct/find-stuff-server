package com.fucct.findstuff.login;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LoginType {
    GITHUB("githubLoginApiService"),
    KAKAO("kakaoLoginApiService"),
    NAVER("naverLoginApiService");

    private final String loginApiServiceName;

    LoginType(String loginApiServiceName) {
        this.loginApiServiceName = loginApiServiceName;
    }

    public String getLoginApiServiceName() {
        return loginApiServiceName;
    }
}
