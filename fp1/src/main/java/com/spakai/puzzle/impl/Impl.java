package com.spakai.puzzle.impl;

import java.util.List;
import com.spakai.puzzle.datamodel.*;
import com.spakai.puzzle.transformer.ReservationT;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Impl {
    
    public void process() {
        
    }
    
    private Map<String, Map<String, BalanceReservation>> processBalanceImpacts(
            final List<BalanceImpact> reservationBalanceImpacts, 
            final List<BalanceImpact> commitBalanceImpacts,
            final List<BalanceDetail> previousBalanceUpdates) {

        Objects.requireNonNull(reservationBalanceImpacts);
        Objects.requireNonNull(commitBalanceImpacts);

        Map<String, Integer> checksumLookup = previousBalanceUpdates
                    .stream()
                    .collect(Collectors.toMap(
                        bd -> bd.getBalanceId(),
                        bd -> bd.getChecksum()
                ));
        
        
        Map<String, BalanceReservation> balReservations = 
                                    reservationBalanceImpacts
                                    .stream()
                                    .collect(Collectors.toMap(
                                             bi -> bi.getBalanceDetail().getBalanceId(), 
                                             ReservationT::createBalanceReservationR
                                     ));
       
        Map<String, Map<String, BalanceReservation>> balCommits = 
                                    commitBalanceImpacts
                                    .stream()
                                    .map(bi -> mergeOrCreateNewReservation(bi, balReservations))
                                    .map(br -> updateChecksum(br, checksumLookup))
                                    .map(br -> updateDeltaMode(br))
                                    .collect(Collectors.groupingBy(
                                            BalanceReservation::getSubscriberId,
                                            Collectors.toMap(
                                                BalanceReservation::getBalanceId,
                                                Function.identity()
                                    )));
        
        return balCommits;
        
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
    
    private BalanceReservation updateChecksum(BalanceReservation br, Map<String, Integer> checksumLookup) {
        Integer cksum = checksumLookup.get(br.getBalanceId());
        
        if (cksum == null) {
            br.setChecksum(cksum + 1);
        } 
        
        return br;
    }
    
    private BalanceReservation updateDeltaMode(BalanceReservation br) {
        return br;
    }
}