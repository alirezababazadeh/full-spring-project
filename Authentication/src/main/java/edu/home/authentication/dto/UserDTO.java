package edu.home.authentication.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDTO {
    private String username;
    private String email;
    private String password;
}
