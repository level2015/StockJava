package com.levelup.stock.model;

import java.util.ArrayList;
import java.util.List;

public class BasicColumnChart {
    private String name;
    private List<Integer> data;

    public BasicColumnChart() {
    }

    public BasicColumnChart(String name, List<Integer> data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setNameOfCurrency(String name) {
        this.name = name;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }
}
