package com.levelup.spring.service.impl;


import com.levelup.spring.dao.UserRepository;
import com.levelup.spring.service.UserService;
import com.levelup.stock.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    public UserServiceImpl() {
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id, User.class);
    }

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public Boolean delete(Long id) {
        return userRepository.delete(id,User.class);
    }
}