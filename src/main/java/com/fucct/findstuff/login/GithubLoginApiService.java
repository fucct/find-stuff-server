package com.fucct.findstuff.login;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fucct.findstuff.config.YamlPropertySourceFactory;

@Component
@PropertySource(value = "classpath:/secret/secret.yml", factory = YamlPropertySourceFactory.class)
public class GithubLoginApiService implements LoginApiService {

    private static final String GITHUB_OAUTH_URL = "https://github.com/login/oauth/access_token";
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${github.client_id}")
    private String clientId;

    @Value("${github.client_secret}")
    private String clientSecret;

    public GithubLoginApiService(ObjectMapper objectMapper) {
        this.restTemplate = new RestTemplateBuilder()
            .defaultHeader("Accept", MediaType.APPLICATION_JSON_VALUE)
            .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            .build();
        this.objectMapper = objectMapper;
    }

    @Override
    public AccessToken getAccessToken(String code) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> urlVariables = new LinkedMultiValueMap<>();
        urlVariables.add("client_id", clientId);
        urlVariables.add("client_secret", clientSecret);
        urlVariables.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(
            urlVariables, headers);

        ResponseEntity<AccessToken> sample = restTemplate.exchange(GITHUB_OAUTH_URL, HttpMethod.POST,
            request, AccessToken.class);
        return sample.getBody();
    }
}
