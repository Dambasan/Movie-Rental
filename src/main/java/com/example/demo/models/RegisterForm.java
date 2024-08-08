package com.example.demo.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RegisterForm {
    @NotEmpty
    @Size(min = 2, max = 50)
    private String name;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String surname;
    @NotEmpty
    @Size(min = 2, max = 50)
    private String email;
    @NotEmpty
    @Size(min = 8, max = 20)
    private String password;
    @NotEmpty
    @Size(min = 8, max = 20)
    private String confirmPassword;

    public RegisterForm() {
    }

    public RegisterForm(String name, String surname, String email, String password, String confirmPassword) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
