package com.restaurant.restsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.restsys.model.Permiso;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long> {
    // Métodos personalizados si son necesarios
}