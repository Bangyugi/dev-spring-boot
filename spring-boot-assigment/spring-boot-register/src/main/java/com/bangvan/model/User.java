package com.bangvan.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", nullable = false, unique = true)
    @NotEmpty(message = " * username is required")
    private String username;

    @Column(name = "password", nullable = false)
    @NotNull(message = " * password is required")
    @Min(value = 5, message = " * password must be greater or equal than 5 digits/chars")
    @Max(value = 20, message = " * password must be less or equal than 20 digits/chars")
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "dob", nullable = false)
    private LocalDate dob;


    @Column(name="confirm_password",nullable = false)
    @NotNull(message = " * password is required")
    private String confirmPassword;

    public User(String username, String password, String firstName, String lastName, String email, String address, LocalDate dob, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.confirmPassword = confirmPassword;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String confirmPassword) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public User(String firstName, String lastName, String email, String address, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.dob = dob;
    }
}
