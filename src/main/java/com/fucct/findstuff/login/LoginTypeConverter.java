package com.fucct.findstuff.login;

import org.springframework.core.convert.converter.Converter;

public class LoginTypeConverter implements Converter<String, LoginType> {
    @Override
    public LoginType convert(String source) {
        return LoginType.valueOf(source.toUpperCase());
    }
}
