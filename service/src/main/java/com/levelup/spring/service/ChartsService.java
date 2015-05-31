package com.levelup.spring.service;

import com.levelup.stock.model.PieChartTest;
import com.levelup.stock.model.dto.LineChartZoom;

import java.util.List;

public interface ChartsService {
    public List<PieChartTest> getPieChartValidData(Long id, Long beginTime, Long endTime);
    public List<LineChartZoom> getDataForLineChart(Long id, Long beginTime, Long endTime);
}
