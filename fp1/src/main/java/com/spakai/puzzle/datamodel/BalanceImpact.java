package com.spakai.puzzle.datamodel;

public class BalanceImpact {
    private String BalanceDetail;
    private String amount;
    private String clearReservationAmount;

    public String getBalanceDetail() {
        return BalanceDetail;
    }

    public void setBalanceDetail(String BalanceDetail) {
        this.BalanceDetail = BalanceDetail;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getClearReservationAmount() {
        return clearReservationAmount;
    }

    public void setClearReservationAmount(String clearReservationAmount) {
        this.clearReservationAmount = clearReservationAmount;
    }
}
