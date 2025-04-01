package com.restaurant.restsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.restsys.model.General;

@Repository
public interface GeneralRepository extends JpaRepository<General, Long> {
    // Métodos personalizados si son necesarios
}