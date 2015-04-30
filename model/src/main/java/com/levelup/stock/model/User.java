package com.levelup.stock.model;

import java.io.Serializable;

/**
 * Created by SMULL on 4/29/2015.
 */

public class User implements Serializable {

    private Long id;
    private String login;
    private String password;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
