package com.oysp.oysp.entity;

public class UserVO {
    private String email;
    private String password;
    private String userName;
    private String userCollege;

    public UserVO(String email, String password, String userName, String userCollege) {
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.userCollege = userCollege;
    }

    public String getEmail() {
        return email;
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
