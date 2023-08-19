package org.example.config.jwt;

import org.example.domain.User;
import org.example.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Duration;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TokenProviderTest {
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProperties jwtProperties;

    @DisplayName("generateToken()")
    @Test
    void generateToken(){
        //given
        User testUser = userRepository.save(User.builder()
                        .email("user@gmail.com")
                        .password("test").build());
        //when
        String token = tokenProvider.generateToken(testUser, Duration.ofDays(14));
        //then
        Long userId = tokenProvider.getUserId(token);

        assertThat(userId).isEqualTo(testUser.getId());
    }

    @DisplayName("validToken(): if token is expired, validation will fail!!")
    @Test
    void validToken_invalidToken(){
        //given
        String token = JwtFactory.builder()
                .expiration(new Date())
                .build()
                .createToken(jwtProperties);
        //when
        boolean result = tokenProvider.validToken(token);
        //then
        assertThat(result).isFalse();
    }

    @DisplayName("validToken(): if token is not expired, validation will success!!")
    @Test
    void validToken_validToken(){
        //given
        String token = JwtFactory.withDefaultValues()
                .createToken(jwtProperties);
        //when
        boolean result = tokenProvider.validToken(token);
        //then
        assertThat(result).isTrue();
    }

    @DisplayName("getAuthentication()")
    @Test
    void getAuthentication(){
        //given
        String userEmail = "user@email.com";
        String token = JwtFactory.builder()
                .subject(userEmail)
                .build()
                .createToken(jwtProperties);
        //when
        Authentication authentication = tokenProvider.getAuthentication(token);
        //then
        assertThat((String)authentication.getCredentials()).isEqualTo(token);
        assertThat(((UserDetails)authentication.getPrincipal()).getUsername()).isEqualTo(userEmail);
    }
}
