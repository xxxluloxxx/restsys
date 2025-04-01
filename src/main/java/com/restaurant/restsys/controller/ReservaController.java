package com.restaurant.restsys.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restsys.dto.ReservaDTO;
import com.restaurant.restsys.model.Reserva;
import com.restaurant.restsys.service.MesaService;
import com.restaurant.restsys.service.ReservaService;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> findAll() {
        List<Reserva> reservas = reservaService.findAll();
        List<ReservaDTO> reservasDTO = reservas.stream()
                .map(reserva -> {
                    ReservaDTO dto = new ReservaDTO();
                    dto.setId(reserva.getId());
                    dto.setMesaId(reserva.getMesa().getId());
                    dto.setNumeroMesa(reserva.getMesa().getNumeroMesa());
                    dto.setNombreCliente(reserva.getNombreCliente());
                    dto.setTelefono(reserva.getTelefono());
                    dto.setFechaReserva(reserva.getFechaReserva().toLocalDate());
                    dto.setHoraReserva(reserva.getHoraReserva());
                    dto.setNumeroPersonas(reserva.getNumeroPersonas());
                    dto.setEstado(reserva.getEstado());
                    dto.setObservaciones(reserva.getObservaciones());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservasDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> findById(@PathVariable Long id) {
        return reservaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/mesa/{mesaId}")
    public ResponseEntity<List<Reserva>> findByMesa(@PathVariable Long mesaId) {
        return mesaService.findById(mesaId)
                .map(mesa -> ResponseEntity.ok(reservaService.findByMesa(mesa)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Reserva>> findByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(reservaService.findByEstado(estado));
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<Reserva>> findByFechaReservaBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
        return ResponseEntity.ok(reservaService.findByFechaReservaBetween(fechaInicio, fechaFin));
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Reserva>> findByNombreCliente(@RequestParam String nombreCliente) {
        return ResponseEntity.ok(reservaService.findByNombreClienteContainingIgnoreCase(nombreCliente));
    }

    @PostMapping
    public ResponseEntity<Reserva> create(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.save(reserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable Long id, @RequestBody Reserva reserva) {
        Reserva updatedReserva = reservaService.update(id, reserva);
        return updatedReserva != null ? ResponseEntity.ok(updatedReserva) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        reservaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}