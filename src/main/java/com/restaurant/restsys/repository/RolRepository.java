package com.restaurant.restsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.restsys.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    // Métodos personalizados si son necesarios
}