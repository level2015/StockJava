package com.levelup.stock.model;

public class PieChartTest {
    private String nameOfCurrency;
    private Float share;

    public PieChartTest() {
    }

    public PieChartTest(String nameOfCurrency, Float share) {
        this.nameOfCurrency = nameOfCurrency;
        this.share = share;

    }

    public String getNameOfCurrency() {
        return nameOfCurrency;
    }

    public void setNameOfCurrency(String nameOfCurrency) {
        this.nameOfCurrency = nameOfCurrency;
    }

    public Float getShare() {
        return share;
    }

    public void setShare(Float share) {
        this.share = share;
    }
}
