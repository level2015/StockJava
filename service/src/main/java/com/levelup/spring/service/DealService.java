package com.levelup.spring.service;

import com.levelup.stock.model.Deal;

public interface DealService {

    public Deal getById(Long id);

    public Deal create(Deal deal);

    public Deal update(Deal deal);

    public Boolean delete(Long id);


}
