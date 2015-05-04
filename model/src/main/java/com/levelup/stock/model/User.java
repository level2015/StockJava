package com.levelup.stock.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "USER")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    private String login;
    private String password;
    @OneToMany(targetEntity = Deal.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="USER_ID", referencedColumnName = "ID")
    List<Deal> deals;

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
