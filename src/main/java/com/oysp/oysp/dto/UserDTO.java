package com.oysp.oysp.dto;

public class UserDTO {

    private String userEmail;
    private String password;
    private String userName;
    private String userCollege;

    public UserDTO(String userEmail, String password, String userName, String userCollege) {
        this.userEmail = userEmail;
        this.password = password;
        this.userName = userName;
        this.userCollege = userCollege;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserCollege() {
        return userCollege;
    }
}
