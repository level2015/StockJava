package com.levelup.spring.service.impl;



import com.levelup.spring.dao.DealRepository;
import com.levelup.spring.service.DealService;
import com.levelup.stock.model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dealService")
public class DealServiceImpl implements DealService {

    @Autowired
    DealRepository dealRepository;

    public DealServiceImpl() {
    }

    @Override
    public Deal getById(Long id) {
        return dealRepository.getById(id, Deal.class);
    }

    @Override
    public Deal create(Deal deal) {
        return dealRepository.create(deal);
    }

    @Override
    public Deal update(Deal deal) {
        return dealRepository.update(deal);
    }

    @Override
    public Boolean delete(Long id) {
        return dealRepository.delete(id,Deal.class);
    }
}
