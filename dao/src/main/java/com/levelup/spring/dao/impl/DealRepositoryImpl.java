package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.AbstractRepository;
import com.levelup.spring.dao.DealRepository;
import com.levelup.stock.model.Deal;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("dealRepository")
@Transactional
public class DealRepositoryImpl extends AbstractRepository<Deal> implements DealRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public DealRepositoryImpl() {
    }


}
