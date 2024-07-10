package dev.reinaldosantos.bankingapi.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import dev.reinaldosantos.bankingapi.domain.user.User;

@Service
public class TokenService {
    @Value("${api-security-token}")
    private String secret;
    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256("");
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while authenticating;");
        }
        return secret;
    }
}
