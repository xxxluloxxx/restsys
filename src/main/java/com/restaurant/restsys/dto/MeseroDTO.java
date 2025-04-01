package com.restaurant.restsys.dto;

import lombok.Data;

@Data
public class MeseroDTO {
    private Long id;
    private Long usuarioId;
    private String usuarioNombres;
}