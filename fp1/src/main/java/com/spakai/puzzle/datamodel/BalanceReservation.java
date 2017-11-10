package com.spakai.puzzle.datamodel;

public class BalanceReservation {
    private String subscriberId;
    private String balanceId;
    private int reservationAmount;
    private int commitAmount;
    private int checksum;

    public int getChecksum() {
        return checksum;
    }

    public void setChecksum(int checksum) {
        this.checksum = checksum;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }
    
    public String getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(String balanceId) {
        this.balanceId = balanceId;
    }

    public int getReservationAmount() {
        return reservationAmount;
    }

    public void setReservationAmount(int reservationAmount) {
        this.reservationAmount = reservationAmount;
    }

    public int getCommitAmount() {
        return commitAmount;
    }

    public void setCommitAmount(int commitAmount) {
        this.commitAmount = commitAmount;
    }
}