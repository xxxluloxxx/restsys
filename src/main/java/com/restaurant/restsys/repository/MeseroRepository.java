package com.restaurant.restsys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.restsys.model.Mesero;
import com.restaurant.restsys.model.Usuario;

@Repository
public interface MeseroRepository extends JpaRepository<Mesero, Long> {
    Optional<Mesero> findByUsuario(Usuario usuario);

    List<Mesero> findByEstado(String estado);
}