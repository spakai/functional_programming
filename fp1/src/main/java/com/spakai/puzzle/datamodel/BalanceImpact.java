package com.spakai.puzzle.datamodel;

public class BalanceImpact {
    private BalanceDetail balanceDetail;
    private String amount;
    private String clearReservationAmount;

    public BalanceDetail getBalanceDetail() {
        return balanceDetail;
    }

    public void setBalanceDetail(BalanceDetail balanceDetail) {
        this.balanceDetail = balanceDetail;
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
