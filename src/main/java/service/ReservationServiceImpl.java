package com.espe.reservationstream.service;

import com.espe.reservationstream.model.ReservationEvent;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Override
    public List<ReservationEvent> filterHighValueReservations(List<ReservationEvent> reservations) {
        if (reservations == null) {
            return List.of();
        }


        return reservations.stream()
                .filter(event -> event.getPrice() != null && event.getPrice() > 300.0)
                .collect(Collectors.toUnmodifiableList());
    }
}