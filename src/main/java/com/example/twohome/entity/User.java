package com.example.twohome.entity;

import com.example.twohome.model.IDEntity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User extends IDEntity {
    @Column(name = "username")
    private String userName;
    private String email;
    private String password;
    private Integer active;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}

