package com.restaurant.restsys.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class PedidoDetalleDTO {
    private Long id;
    private Integer numeroMesa;
    private String nombreMesero;
    private String estado;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime fechaPedido;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaPedido;

    private BigDecimal total;
    private String observaciones;
    private List<DetallePedidoDTO> detalles;

    @Data
    public static class DetallePedidoDTO {
        private String nombreProducto;
        private Integer cantidad;
        private BigDecimal precioUnitario;
        private BigDecimal subtotal;
        private String observaciones;
    }
}