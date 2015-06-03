package com.levelup.stock.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasicBarChart {
    private String name;
    private List<Double> data;
    private List<String> year;

    public BasicBarChart() {
    }

    public BasicBarChart(String name, List<Double> data) {
        this.name = name;
        this.data = data;
    }

    public List<String> getYear() {
        return year;
    }

    public void setYear(List<String> year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }
}
