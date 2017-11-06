package com.spakai.puzzle.datamodel;

public class BalanceReservation {
    private String balanceId;
    private String reservationAmount;
    private String commitAmount;

    public String getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(String balanceId) {
        this.balanceId = balanceId;
    }

    public String getReservationAmount() {
        return reservationAmount;
    }

    public void setReservationAmount(String reservationAmount) {
        this.reservationAmount = reservationAmount;
    }

    public String getCommitAmount() {
        return commitAmount;
    }

    public void setCommitAmount(String commitAmount) {
        this.commitAmount = commitAmount;
    }
}