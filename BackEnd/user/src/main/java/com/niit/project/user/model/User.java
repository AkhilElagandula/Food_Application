package com.niit.project.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    private String fullName;
    @Id
    private String emailId;
    private long mobileNo;
    private String password;
    private String confirmPassword;

    private String role;
//    private String imageUrl;

    public User(){}

    public User(String fullName, String emailId, long mobileNo, String password, String confirmPassword, String role) {
        this.fullName = fullName;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileNo=" + mobileNo +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
