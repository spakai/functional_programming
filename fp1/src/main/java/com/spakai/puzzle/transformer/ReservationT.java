package com.spakai.puzzle.transformer;

import com.spakai.puzzle.datamodel.BalanceImpact;
import com.spakai.puzzle.datamodel.BalanceReservation;

public  class ReservationT {
    public static BalanceReservation createBalanceReservationR(BalanceImpact bi) {
        BalanceReservation br = new BalanceReservation();
        br.setBalanceId(bi.getBalanceDetail().getBalanceId());
        br.setReservationAmount(bi.getAmount());
        br.setSubscriberId(bi.getBalanceDetail().getSubscriberId());
        br.setChecksum(bi.getBalanceDetail().getChecksum());
        return br;
    }
    
     public static BalanceReservation createBalanceReservationC(BalanceImpact bi) {
        BalanceReservation br = new BalanceReservation();
        br.setBalanceId(bi.getBalanceDetail().getBalanceId());
        br.setReservationAmount(bi.getClearReservationAmount()); // later negate this
        br.setCommitAmount(bi.getAmount());
        br.setSubscriberId(bi.getBalanceDetail().getSubscriberId());
        br.setChecksum(bi.getBalanceDetail().getChecksum());
        return br;
    }
    
}
