package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.AbstractRepository;
import com.levelup.spring.dao.UserRepository;
import com.levelup.stock.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRepositoryImpl() {
    }


}
