package com.espe.reservation_stream.controller;

import com.espe.reservation_stream.model.ReservationEvent;
import com.espe.reservation_stream.service.ReservationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    // Inyección de dependencias por constructor
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Endpoint reactivo continuo (Server-Sent Events)
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ReservationEvent> streamHighValueReservations() {
        // Datos de prueba simulados con inmutabilidad estricta
        List<ReservationEvent> mockEvents = List.of(
                new ReservationEvent("1", "Maribel Amaguaña", 450.0, List.of("maribel@espe.edu.ec")),
                new ReservationEvent("2", "Carlos Pérez", 150.0, List.of("carlos@example.com")),
                new ReservationEvent("3", "Ana Gómez", 600.0, List.of("ana@example.com")),
                new ReservationEvent("4", "Luis Torres", 280.0, List.of("luis@example.com")),
                new ReservationEvent("5", "Alex Melo", 800.0, List.of("alex@example.com"))
        );

        // Filtrado utilizando la lógica declarativa y funcional de la Actividad 2
        List<ReservationEvent> filtered = reservationService.filterHighValueReservations(mockEvents);

        // Emisión reactiva no bloqueante: envía un evento cada 2 segundos asíncronamente
        return Flux.fromIterable(filtered)
                .delayElements(Duration.ofSeconds(2));
    }
}