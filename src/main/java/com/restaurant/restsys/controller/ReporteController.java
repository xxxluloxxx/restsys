package com.restaurant.restsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restsys.dto.ProductoReporteDTO;
import com.restaurant.restsys.service.ReporteService;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping("/productos-mas-vendidos")
    public ResponseEntity<List<ProductoReporteDTO>> getProductosMasVendidos() {
        return ResponseEntity.ok(reporteService.getProductosMasVendidos());
    }
}