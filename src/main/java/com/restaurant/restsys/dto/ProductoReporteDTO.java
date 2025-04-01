package com.restaurant.restsys.dto;

import lombok.Data;

@Data
public class ProductoReporteDTO {
    private Long id;
    private String nombre;
    private Integer porcentaje;

    public ProductoReporteDTO(Long id, String nombre, Double porcentaje) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = (int) Math.round(porcentaje);
    }
}