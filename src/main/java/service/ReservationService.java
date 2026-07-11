package com.espe.reservationstream.service;

import com.espe.reservationstream.model.ReservationEvent;
import java.util.List;

public interface ReservationService {
    List<ReservationEvent> filterHighValueReservations(List<ReservationEvent> reservations);
}