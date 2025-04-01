package com.restaurant.restsys.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.restsys.model.Mesa;
import com.restaurant.restsys.model.Reserva;
import com.restaurant.restsys.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Transactional(readOnly = true)
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Reserva> findByMesa(Mesa mesa) {
        return reservaRepository.findByMesa(mesa);
    }

    @Transactional(readOnly = true)
    public List<Reserva> findByEstado(String estado) {
        return reservaRepository.findByEstado(estado);
    }

    @Transactional(readOnly = true)
    public List<Reserva> findByFechaReservaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return reservaRepository.findByFechaReservaBetween(fechaInicio, fechaFin);
    }

    @Transactional(readOnly = true)
    public List<Reserva> findByNombreClienteContainingIgnoreCase(String nombreCliente) {
        return reservaRepository.findByNombreClienteContainingIgnoreCase(nombreCliente);
    }

    @Transactional
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Transactional
    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

    @Transactional
    public Reserva update(Long id, Reserva reserva) {
        if (reservaRepository.existsById(id)) {
            reserva.setId(id);
            return reservaRepository.save(reserva);
        }
        return null;
    }
}