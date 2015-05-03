package com.levelup.stock.model;

/**
 * Created by Eugene on 03.05.2015.
 */
public class pieChartTest {
    private String nameOfCurrency;
    private Float share;

    public pieChartTest() {
    }

    public pieChartTest(String nameOfCurrency, Float share) {
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
