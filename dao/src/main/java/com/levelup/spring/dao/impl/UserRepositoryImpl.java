package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.AbstractRepository;
import com.levelup.spring.dao.UserRepository;
import com.levelup.stock.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("userRepository")
@Transactional
public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRepositoryImpl() {
    }

    @Override
    public List<User> getUserByEmail(String email) {

        Query query = entityManager.createNativeQuery("select * from user u where u.email = :userEmail");
        query.setParameter("userEmail", email.toLowerCase());
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public Boolean checkUserByEmail(User user) {
        if (getUserByEmail(user.getEmail().toLowerCase()).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Boolean checkUserByEmailAndPassword(User user) {
        Query query = entityManager.createNativeQuery("select * from user u where u.email = :userEmail and u.password=:userPassword");

        query.setParameter("userEmail", user.getEmail().toLowerCase());
        query.setParameter("userPassword", user.getPassword());
        List<User> users = query.getResultList();
        if (users.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
