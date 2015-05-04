package com.levelup.stock.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DEAL")
public class Deal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Long id;
    @Column(name = "USER_ID")
    Long userId;
    private String Type;
    private String Ticket;
    private String Symbol;
    private String Lots;
    private String BuySell;
    private String OpenPrice;
    private String ClosePrice;
    private String OpenTime;
    private String CloseTime;
    private String Profit;
    private String Swap;
    private String Commission;
    private String TP;
    private String SL;
    private String Pips;
    private String Result;
    private String TradeDuration;
    private String MagicNnumber;
    private String OrderComment;
    private String MAE;
    private String MFE_FX_Blue_Live_account;


    public Deal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getLots() {
        return Lots;
    }

    public void setLots(String lots) {
        Lots = lots;
    }

    public String getBuySell() {
        return BuySell;
    }

    public void setBuySell(String buySell) {
        BuySell = buySell;
    }

    public String getOpenPrice() {
        return OpenPrice;
    }

    public void setOpenPrice(String openPrice) {
        OpenPrice = openPrice;
    }

    public String getClosePrice() {
        return ClosePrice;
    }

    public void setClosePrice(String closePrice) {
        ClosePrice = closePrice;
    }

    public String getOpenTime() {
        return OpenTime;
    }

    public void setOpenTime(String openTime) {
        OpenTime = openTime;
    }

    public String getCloseTime() {
        return CloseTime;
    }

    public void setCloseTime(String closeTime) {
        CloseTime = closeTime;
    }

    public String getProfit() {
        return Profit;
    }

    public void setProfit(String profit) {
        Profit = profit;
    }

    public String getSwap() {
        return Swap;
    }

    public void setSwap(String swap) {
        Swap = swap;
    }

    public String getCommission() {
        return Commission;
    }

    public void setCommission(String commission) {
        Commission = commission;
    }

    public String getTP() {
        return TP;
    }

    public void setTP(String TP) {
        this.TP = TP;
    }

    public String getSL() {
        return SL;
    }

    public void setSL(String SL) {
        this.SL = SL;
    }

    public String getPips() {
        return Pips;
    }

    public void setPips(String pips) {
        Pips = pips;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getTradeDuration() {
        return TradeDuration;
    }

    public void setTradeDuration(String tradeDuration) {
        TradeDuration = tradeDuration;
    }

    public String getMagicNnumber() {
        return MagicNnumber;
    }

    public void setMagicNnumber(String magicNnumber) {
        MagicNnumber = magicNnumber;
    }

    public String getOrderComment() {
        return OrderComment;
    }

    public void setOrderComment(String orderComment) {
        OrderComment = orderComment;
    }

    public String getMAE() {
        return MAE;
    }

    public void setMAE(String MAE) {
        this.MAE = MAE;
    }

    public String getMFE_FX_Blue_Live_account() {
        return MFE_FX_Blue_Live_account;
    }

    public void setMFE_FX_Blue_Live_account(String MFE_FX_Blue_Live_account) {
        this.MFE_FX_Blue_Live_account = MFE_FX_Blue_Live_account;
    }
}
