package com.restaurant.restsys.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ReservaDTO {
    private Long id;
    private Long mesaId;
    private Integer numeroMesa;
    private String nombreCliente;
    private String telefono;
    private LocalDate fechaReserva;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaReserva;

    private Integer numeroPersonas;
    private String estado;
    private String observaciones;
}