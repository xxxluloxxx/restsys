package com.restaurant.restsys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.restsys.dto.ProductoReporteDTO;
import com.restaurant.restsys.repository.PedidoRepository;

@Service
public class ReporteService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<ProductoReporteDTO> getProductosMasVendidos() {
        return pedidoRepository.findTop10ProductosMasVendidos();
    }
}