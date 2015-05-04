package com.levelup.spring.service;


import com.levelup.stock.model.User;

public interface UserService {

    public User getById(Long id);

    public User create(User user);

    public User update(User user);

    public Boolean delete(Long id);

}
