package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.AbstractRepository;
import com.levelup.spring.dao.DealRepository;
import com.levelup.spring.dao.UserRepository;
import com.levelup.stock.model.BasicColumnChart;
import com.levelup.stock.model.Deal;
import com.levelup.stock.model.dto.SymbolProfit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

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

    @Override
    public List<SymbolProfit> getAllUniqe(String userEmail, Long beginTime, Long endTime) {

        java.util.Date beginDate = new Date(beginTime);
        java.util.Date endDate = new Date(endTime);
        Object beginD = new java.sql.Timestamp(beginDate.getTime());
        Object endD = new java.sql.Timestamp(endDate.getTime());
        try {
            Long userId = userRepository.getUserByEmail(userEmail).get(0).getId();
//        String queryStr="select d.symbol, sum(d.profit) as profitSum from Deal d group by d.symbol";
            //      TypedQuery<SymbolProfit> query = entityManager.createQuery("select d.symbol, sum(d.profit) as profitSum from Deal d where d.closeTime>:param and d.userId=:userID group by d.symbol", SymbolProfit.class);
            Query query = entityManager.createQuery("select d.symbol, sum(d.profit) as profitSum from Deal d where d.closeTime Between:beginD and :endD and d.userId=:userID group by d.symbol");
            query.setParameter("userID", userId);
            query.setParameter("beginD", beginD);
            query.setParameter("endD", endD);
//        List<SymbolProfit> queryResultList = query.getResultList();
            List<Object[]> queryResultList = query.getResultList();

            List<SymbolProfit> listSymbolProfits = new ArrayList<>();

            for (Object[] result : queryResultList) {
                SymbolProfit symbolProfit = new SymbolProfit();
                symbolProfit.setSymbol(result[0].toString());
                symbolProfit.setProfit(Double.parseDouble(result[1].toString()));
                listSymbolProfits.add(symbolProfit);
            }
            return listSymbolProfits;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<BasicColumnChart> getSumProfit(String userEmail, Long beginTime, Long endTime) {

        Object beginD = new java.sql.Timestamp(beginTime);
        Object endD = new java.sql.Timestamp(endTime);
        try {
            Long userId = userRepository.getUserByEmail(userEmail).get(0).getId();
//        String queryStr="select d.symbol, sum(d.profit) as profitSum from Deal d group by d.symbol";
            //      TypedQuery<SymbolProfit> query = entityManager.createQuery("select d.symbol, sum(d.profit) as profitSum from Deal d where d.closeTime>:param and d.userId=:userID group by d.symbol", SymbolProfit.class);
            Query query = entityManager.createQuery("select Year(closeTime),d.symbol, sum(d.profit) as profitSum from Deal d where year(d.closeTime) Between:beginD and :endD and d.userId=:userID group by date_format(d.closeTime, '%y'), d.symbol");
            query.setParameter("userID", userId);
            query.setParameter("beginD", beginD);
            query.setParameter("endD", endD);
//        List<SymbolProfit> queryResultList = query.getResultList();
            List<Object[]> queryResultList = query.getResultList();

            List<BasicColumnChart> listBasicColumnChart = new ArrayList<>();
            ArrayList<Double> listDoubleData = new ArrayList<>();

            for (int i = 0; i < queryResultList.size(); i++) {
                BasicColumnChart basicColumnChart = new BasicColumnChart();
                Object[] temp = queryResultList.get(i);
                Object[] temp2 = {};
                if (i > 0) {
                    temp2 = queryResultList.get(i - 1);
                }
                if (temp[0].equals(temp2[0])) {
                    listDoubleData.add(Double.parseDouble(temp[1].toString()));
                    basicColumnChart.setData(listDoubleData);
                } else {
                    listDoubleData = new ArrayList<>();
                    basicColumnChart.setNameOfCurrency(temp[0].toString());
                    listDoubleData.add(Double.parseDouble(temp[1].toString()));
                    basicColumnChart.setData(listDoubleData);
                }


            }
            return listBasicColumnChart;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
