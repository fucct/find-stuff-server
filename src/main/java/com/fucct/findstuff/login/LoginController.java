package com.fucct.findstuff.login;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fucct.findstuff.config.YamlPropertySourceFactory;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
@PropertySource(value = "classpath:/secret/secret.yml", factory = YamlPropertySourceFactory.class)
public class LoginController {
    private final LoginService loginService;

    @Value("${server.user_info_uri}")
    private String userInfoUri;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/{type}")
    public AccessToken login(@PathVariable LoginType type, @RequestParam String code) throws JsonProcessingException {
        AccessToken accessToken = loginService.getAccessToken(type, code);

        return accessToken;
    }

}
