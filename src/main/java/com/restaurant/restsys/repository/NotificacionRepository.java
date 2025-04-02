package com.restaurant.restsys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.restsys.model.Notificacion;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByEstado(Boolean estado);

    Optional<Notificacion> findByNumeroMesaAndEstado(Integer numeroMesa, Boolean estado);
}