package com.fucct.findstuff.login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fucct.findstuff.config.YamlPropertySourceFactory;

@Component
@PropertySource(value = "classpath:/secret/secret.yml", factory = YamlPropertySourceFactory.class)
public class KakaoLoginApiService implements LoginApiService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${kakao.oauth_uri}")
    private String OAuthUri;

    @Value("${kakao.client_id}")
    private String clientId;

    @Value("${kakao.client_secret}")
    private String clientSecret;

    @Value("${kakao.api_uri}")
    private String apiUri;

    @Value("${server.user_info_uri}")
    private String userInfoUri;

    public KakaoLoginApiService(ObjectMapper objectMapper) {
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

        ResponseEntity<AccessToken> sample = restTemplate.exchange(OAuthUri, HttpMethod.POST,
            request, AccessToken.class);
        return sample.getBody();
    }
}
