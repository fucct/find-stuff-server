package com.fucct.findstuff.login;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {
    private final LoginService loginService;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping
    public String login(@RequestParam String code) {
        String accessToken = loginService.getAccessToken(code);
        return "LOL"+accessToken;
    }

}
