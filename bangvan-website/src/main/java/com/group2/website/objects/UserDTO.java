package com.group2.website.objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class UserDTO {
    @NotBlank(message = "Enter your username")
    private String username;

    @NotBlank(message = "Enter your password")
    @Length(min =6, message = "Passsword must be at least 6 characters")
    private String password;

    @NotBlank(message = "Re-enter your password")
    private String rpassword;
    private String role;

    @NotBlank(message = "Enter your email")
    @Email(message = "Enter a valid email address")
    private String email;

    public UserDTO() {
    }

    public UserDTO(String username, String password, String rpassword, String email) {
        this.username = username;
        this.password = password;
        this.rpassword = rpassword;
        this.email = email;
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rpassword='" + rpassword + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
