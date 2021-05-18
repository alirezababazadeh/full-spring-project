package edu.home.authentication.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AuthResponse {

    private String accessToken;
    private String refreshToken;

}
