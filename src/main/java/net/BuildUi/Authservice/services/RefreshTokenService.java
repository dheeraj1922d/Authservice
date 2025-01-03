package net.BuildUi.Authservice.services;

import net.BuildUi.Authservice.entities.RefreshToken;
import net.BuildUi.Authservice.entities.UserInfo;
import net.BuildUi.Authservice.repositories.RefreshTokenRepository;
import net.BuildUi.Authservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RefreshTokenRepository refreshTokenRepository;
    public RefreshToken createRefreshToken(String username){
        UserInfo extractedInfo = userRepository.findByUsername(username);
        RefreshToken refreshToken = RefreshToken.builder()
                .userInfo(extractedInfo)
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(600000))
                .build();
        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().compareTo(Instant.now()) < 0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Token has expired. Please Login again..");
        }
        return token;
    }

    public Optional<RefreshToken> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }
}
