package com.levelup.spring.dao.impl;

import com.levelup.spring.dao.AbstractRepository;
import com.levelup.spring.dao.DealRepository;
import com.levelup.spring.dao.UserRepository;
import com.levelup.stock.model.dto.BasicBarChart;
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
//          TypedQuery<SymbolProfit> query = entityManager.createQuery("select d.symbol, sum(d.profit) as profitSum from Deal d where d.closeTime>:param and d.userId=:userID group by d.symbol", SymbolProfit.class);
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
    public List<BasicBarChart> getSumProf(String userEmail, Long beginTime, Long endTime) {
        String query = "select d.symbol, round(sum(d.profit),2) as profitSum, date_format(d.closeTime, '20%y/%m') as da from Deal d where d.closeTime Between :beginD and :endD and d.userId=:userID group by date_format(d.closeTime, '%y %m'), d.symbol Order by date_format(d.closeTime, '%y %m') asc";
        return getlistBasicBarChart(query, userEmail, beginTime, endTime);
    }

    @Override
    public List<BasicBarChart> getSumProfit(String userEmail, Long beginTime, Long endTime) {
        String query = "select d.symbol, round(sum(d.profit),2) as profitSum, Year(d.closeTime)  from Deal d where d.closeTime Between :beginD and :endD and d.userId=:userID group by date_format(d.closeTime, '%y'), d.symbol Order by Year(d.closeTime) asc";
        return getlistBasicBarChart(query, userEmail, beginTime, endTime);
    }

    //Осторожно говнокод!!!
    public List<BasicBarChart> getlistBasicBarChart(String hqlQuery, String userEmail, Long beginTime, Long endTime) {
        try {
            Object beginD = new java.sql.Timestamp(beginTime);
            Object endD = new java.sql.Timestamp(endTime);

            Long userId = userRepository.getUserByEmail(userEmail).get(0).getId();
            Query query = entityManager.createQuery(hqlQuery);
            query.setParameter("userID", userId);
            query.setParameter("beginD", beginD);
            query.setParameter("endD", endD);

            List<Object[]> queryResultList = query.getResultList();
            List<BasicBarChart> listBasicBarChart = new ArrayList<>();
            Set<String> years = new TreeSet<>();
            ArrayList<Double> listDoubleData = new ArrayList<>(years.size());

            for (Object[] temp : queryResultList) {
                years.add(temp[2].toString());
            }
            for (int i = 0; i < years.size(); i++) {
                listDoubleData.add(null);
            }
            for (Object[] temp : queryResultList) {
                boolean flag = false;
                for (BasicBarChart aListBasicBarChart : listBasicBarChart) {
                    if (temp[0].equals(aListBasicBarChart.getName())) {
                        years.add(temp[2].toString());
                        aListBasicBarChart.setYear(new ArrayList<>(years));
                        aListBasicBarChart.setData(new ArrayList(listDoubleData));
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                } else {
                    BasicBarChart basicBarChart = new BasicBarChart();
                    basicBarChart.setName(temp[0].toString());
                    years.add(temp[2].toString());
                    basicBarChart.setYear(new ArrayList<>(years));
                    basicBarChart.setData(new ArrayList(listDoubleData));
                    listBasicBarChart.add(basicBarChart);
                }
            }
            for (Object[] temp : queryResultList) {
                for (BasicBarChart aListBasicBarChart : listBasicBarChart) {
                    for (int k = 0; k < aListBasicBarChart.getYear().size(); k++) {
                        if (temp[0].toString().equals(aListBasicBarChart.getName()) && temp[2].toString().equals(aListBasicBarChart.getYear().get(k))) {
                            aListBasicBarChart.getData().set(k, Double.parseDouble(temp[1].toString()));
                            break;
                        }
                    }
                }
            }
            listBasicBarChart.get(0).setYear(new ArrayList<>(years));
            return listBasicBarChart;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}

