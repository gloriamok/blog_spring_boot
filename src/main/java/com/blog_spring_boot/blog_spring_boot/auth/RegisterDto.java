package com.blog_spring_boot.blog_spring_boot.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String username;
    @Email
    private String email;
    @NotEmpty
    private String password;
}
