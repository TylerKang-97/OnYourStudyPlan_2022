package com.oysp.oysp.entity;

public class InfoVO {
//    private String userName;
//    private String userCollege;
    private String email;
    private String subjectName;
    private Integer credit;

    public InfoVO(String email, String subjectName, Integer credit) {
//        this.userName = userName;
//        this.userCollege = userCollege;
        this.email = email;
        this.subjectName = subjectName;
        this.credit = credit;
    }

//    public String getUserName() {
//        return userName;
//    }

//    public String getUserCollege() {
//        return userCollege;
//    }


    public String getEmail() {
        return email;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Integer getCredit() {
        return credit;
    }
}
