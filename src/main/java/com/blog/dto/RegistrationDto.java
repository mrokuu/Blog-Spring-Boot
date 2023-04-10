package com.blog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "password should not be empty")
    private String password;
}
