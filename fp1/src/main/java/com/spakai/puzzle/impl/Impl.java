package com.spakai.puzzle.impl;

import java.util.ArrayList;
import java.util.List;
import com.spakai.puzzle.datamodel.*;
import java.util.Map;
import java.util.stream.Collectors;

public class Impl {
   
    public void processBalanceImpacts() {
        List<BalanceImpact> reservationBalanceImpacts = new ArrayList<>();
        List<BalanceImpact> commitBalanceImpacts = new ArrayList<>();
                
        //Create lookup map from first list
        // balanceId , BalanceReservation
        Map<String, BalanceReservation> balReservations = reservationBalanceImpacts
                                     .stream()
                                     .collect(Collectors.toMap(
                                             bi -> bi.getBalanceDetail().getBalanceId(), 
                                             bi -> createBalanceReservationR(bi)
                                     ));
       
        
        /*Map<String, Map<String, BalanceReservation>> balanceCommitsWithSubscriberId 
                = commitBalanceImpacts
                        .stream()
                        .map(bi -> balReservations.getOrDefault(bi.getBalanceDetail().getBalanceId()))*/
        
        
    }
    
    
    private BalanceReservation createBalanceReservationR(BalanceImpact bi) {
        BalanceReservation br = new BalanceReservation();
        br.setBalanceId(bi.getBalanceDetail().getBalanceId());
        br.setReservationAmount(bi.getAmount());
        return br;
    }
    
}