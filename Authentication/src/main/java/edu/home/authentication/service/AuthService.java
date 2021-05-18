package edu.home.authentication.service;

import edu.home.authentication.model.LoginRequest;
import edu.home.authentication.model.RegisterRequest;
import edu.home.authentication.model.AuthResponse;
import edu.home.authentication.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {

    private final RestTemplate restTemplate;
    private final JwtUtil jwt;

    @Autowired
    public AuthService(RestTemplate restTemplate, final JwtUtil jwt) {
        this.restTemplate = restTemplate;
        this.jwt = jwt;
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        registerRequest.setPassword(BCrypt.hashpw(registerRequest.getPassword(), BCrypt.gensalt()));

        UserDTO userDTO = restTemplate.postForObject("http://user-service/user/create", registerRequest, UserDTO.class);
        Assert.notNull(userDTO, "Failed to register user. Please try again later");

        String accessToken = jwt.generate(userDTO, "ACCESS");
        String refreshToken = jwt.generate(userDTO, "REFRESH");

        return new AuthResponse(accessToken, refreshToken);

    }

    public AuthResponse login(LoginRequest loginRequest) {
        loginRequest.setPassword(BCrypt.hashpw(loginRequest.getPassword(), BCrypt.gensalt()));

        UserDTO userDTO = restTemplate.postForObject("http://user-service/user/read", loginRequest, UserDTO.class);
        Assert.notNull(userDTO, "Failed to login user. Please try again later");

        String accessToken = jwt.generate(userDTO, "ACCESS");
        String refreshToken = jwt.generate(userDTO, "REFRESH");

        return new AuthResponse(accessToken, refreshToken);
    }
}
