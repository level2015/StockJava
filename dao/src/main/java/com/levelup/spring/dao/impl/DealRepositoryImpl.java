package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.AbstractRepository;
import com.levelup.spring.dao.DealRepository;
import com.levelup.spring.dao.UserRepository;
import com.levelup.stock.model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Repository("dealRepository")
@Transactional
public class DealRepositoryImpl extends AbstractRepository<Deal> implements DealRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    UserRepository userRepository;

    public DealRepositoryImpl() {
    }

    @Override
    public List<String> getAllUniqeSymbol(String userEmail) {
        Long userId = userRepository.getUserByEmail(userEmail).get(0).getId();
        Query query = entityManager.createQuery("SELECT DISTINCT d.symbol from Deal d where d.userId=:userID");
        query.setParameter("userID", userId);
        List<String> uniqeSymbols = query.getResultList();
        return uniqeSymbols;
    }

}
