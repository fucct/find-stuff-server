package com.fucct.findstuff.login;

import java.beans.ConstructorProperties;

import net.bytebuddy.NamingStrategy;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(onConstructor_ = @ConstructorProperties({"accessToken", "tokenType", "state"}))
@Getter
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AccessToken {
    private final String accessToken;
    private final String tokenType;
    private final String state;
}
