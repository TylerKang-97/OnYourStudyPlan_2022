package com.oysp.oysp.dto;

public class LoginDTO {
    private String userEmail;
    private String password;

    public LoginDTO(String userEmail, String password) {
        this.userEmail = userEmail;
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }
}
