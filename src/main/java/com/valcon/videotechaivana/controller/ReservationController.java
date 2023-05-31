package com.valcon.videotechaivana.controller;

import com.valcon.videotechaivana.dto.ReservationRequestDTO;
import com.valcon.videotechaivana.dto.ReservationResponseDTO;
import com.valcon.videotechaivana.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ReservationResponseDTO create(@Valid @RequestBody ReservationRequestDTO reservationRequestDTO) {
        return reservationService.create(reservationRequestDTO);
    }

    @GetMapping
    public List<ReservationResponseDTO> getAll() {
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public ReservationResponseDTO getActiveById(@PathVariable Long id) {
        return reservationService.getActiveById(id);
    }

    @PatchMapping("/{id}")
    public void cancelById(@PathVariable Long id) {
        reservationService.cancelById(id);
    }

}
