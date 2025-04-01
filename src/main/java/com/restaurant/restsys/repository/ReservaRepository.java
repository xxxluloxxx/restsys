package com.restaurant.restsys.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.restsys.model.Mesa;
import com.restaurant.restsys.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByMesa(Mesa mesa);

    List<Reserva> findByEstado(String estado);

    List<Reserva> findByFechaReservaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    List<Reserva> findByNombreClienteContainingIgnoreCase(String nombreCliente);
}