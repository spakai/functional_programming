package com.spakai.puzzle.impl;

import java.util.List;
import com.spakai.puzzle.datamodel.*;
import com.spakai.puzzle.transformer.ReservationT;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Impl {
    
    public void process() {
        
    }
    
    private void processBalanceImpacts(final List<BalanceImpact> reservationBalanceImpacts, final List<BalanceImpact> commitBalanceImpacts) {
        //Create lookup map from first list
        // balanceId , BalanceReservation
        Map<String, BalanceReservation> balReservations = 
                                    reservationBalanceImpacts
                                    .stream()
                                    .collect(Collectors.toMap(
                                             bi -> bi.getBalanceDetail().getBalanceId(), 
                                             ReservationT::createBalanceReservationR
                                     ));
       
        Map<String, BalanceReservation> balCommits = 
                                    commitBalanceImpacts
                                    .stream()
                                    .map(bi -> mergeOrCreateNewReservation(bi, balReservations))
                                    .collect(Collectors.toMap(
                                        BalanceReservation::getBalanceId,
                                        Function.identity()
                                    ));
        //next map above to subscriberId
        
        //Map<String, Map<String, BalanceReservation>> balanceCommitsWithSubscriberId 
    }
    
    private BalanceReservation mergeOrCreateNewReservation(BalanceImpact bi, Map<String, BalanceReservation> balReservations) {
        BalanceReservation br = balReservations.get(bi.getBalanceDetail().getBalanceId());
         if (br == null) {
             return ReservationT.createBalanceReservationC(bi);
         } else {
             br.setCommitAmount(bi.getAmount());
             //br.setReservationAmount(br.getReservationAmount() - bi.getClearReservationAmount();
             return br;
         }
    }
}