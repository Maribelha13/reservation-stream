package com.espe.reservation_stream.service;

import com.espe.reservation_stream.model.ReservationEvent;
import java.util.List;

public interface ReservationService {
    List<ReservationEvent> filterHighValueReservations(List<ReservationEvent> reservations);
}