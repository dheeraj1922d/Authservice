package net.BuildUi.Authservice.controller;

import net.BuildUi.Authservice.entities.RefreshToken;
import net.BuildUi.Authservice.requests.RefreshTokenRequest;
import net.BuildUi.Authservice.response.JwtTokenResponse;
import net.BuildUi.Authservice.services.JwtService;
import net.BuildUi.Authservice.services.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class TokenController {

    @Autowired
    private RefreshTokenService refreshTokenService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("auth/v1/refreshToken")
    public JwtTokenResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequestDTO){
        return refreshTokenService.findByToken(refreshTokenRequestDTO.getToken())
                .map(refreshTokenService::verifyExpiration)
                .map(RefreshToken::getUserInfo)
                .map(userInfo -> {
                    String accessToken = jwtService.GenerateToken(userInfo.getUsername());
                    return JwtTokenResponse.builder()
                            .accessToken(accessToken)
                            .token(refreshTokenRequestDTO.getToken()).build();
                }).orElseThrow(() ->new RuntimeException("Refresh Token is not in DB..!!"));
    }
}
