/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spakai.puzzle.transformer;

import com.spakai.puzzle.datamodel.BalanceImpact;
import com.spakai.puzzle.datamodel.BalanceReservation;


public  class ReservationT {
    public static BalanceReservation createBalanceReservationR(BalanceImpact bi) {
        BalanceReservation br = new BalanceReservation();
        br.setBalanceId(bi.getBalanceDetail().getBalanceId());
        br.setReservationAmount(bi.getAmount());
        return br;
    }
    
     public static BalanceReservation createBalanceReservationC(BalanceImpact bi) {
        BalanceReservation br = new BalanceReservation();
        br.setBalanceId(bi.getBalanceDetail().getBalanceId());
        br.setReservationAmount(bi.getClearReservationAmount()); // later negate this
        br.setCommitAmount(bi.getAmount());
        return br;
    }
    
}
