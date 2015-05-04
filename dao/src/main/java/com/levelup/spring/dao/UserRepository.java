package com.levelup.spring.dao;

import com.levelup.stock.model.User;

public interface UserRepository {

    public User getById(Long id, Class entityClass);

    public User create(User user);

    public User update(User user);

    public Boolean delete(Long id, Class entityClass);
}
