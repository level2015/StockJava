package com.levelup.spring.dao;

import com.levelup.stock.model.Deal;

public interface DealRepository {

    public Deal getById(Long id, Class entityClass);

    public Deal create(Deal deal);

    public Deal update(Deal deal);

    public Boolean delete(Long id, Class entityClass);
}
