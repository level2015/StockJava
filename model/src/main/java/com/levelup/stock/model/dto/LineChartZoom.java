package com.levelup.stock.model.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by java on 26.05.2015.
 */
public class LineChartZoom {
    String name;
    List<Double> data = new ArrayList<Double>();

    public LineChartZoom() {
    }

    public List<Double> getData() {
        return data;
    }

    public void setData(List<Double> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
