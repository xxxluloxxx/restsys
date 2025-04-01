package com.restaurant.restsys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.restsys.model.Categoria;
import com.restaurant.restsys.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findByNombre(String nombre);

    List<Producto> findByCategoria(Categoria categoria);

    List<Producto> findByDisponible(Boolean disponible);
}