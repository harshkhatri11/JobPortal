package com.example.JobPortal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String email;

    @NotEmpty
    private String password;

    private boolean isActive;


    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date registrationDate;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userTypeId",referencedColumnName = "userTypeId")
    private UsersType userTypeId;

    public Users(){}

    public Users(int userId, String email, String password, boolean isActive, Date registartionDate, UsersType userTypeId) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.registrationDate = registartionDate;
        this.userTypeId = userTypeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getRegistartionDate() {
        return registrationDate;
    }

    public void setRegistartionDate(Date registartionDate) {
        this.registrationDate = registartionDate;
    }

    public UsersType getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(UsersType userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", registartionDate=" + registrationDate +
                ", userTypeId=" + userTypeId +
                '}';
    }
}
