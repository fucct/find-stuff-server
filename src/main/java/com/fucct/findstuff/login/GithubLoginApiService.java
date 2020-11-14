package com.fucct.findstuff.login;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fucct.findstuff.config.YamlPropertySourceFactory;

@Component
@PropertySource(value = "classpath:/secret/secret.yml", factory = YamlPropertySourceFactory.class)
public class GithubLoginApiService implements LoginApiService{

    private static final String GITHUB_OAUTH_URL = "https://github.com/login/oauth/access_token";
    private final RestTemplate restTemplate;

    @Value("${github.secret}")
    private String client_secret;

    public GithubLoginApiService() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
         this.restTemplate = builder.build();
    }

    @Override
    public String getAccessToken(String code) {
        return client_secret;
    }
}
