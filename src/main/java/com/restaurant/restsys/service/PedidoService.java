package com.restaurant.restsys.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.restsys.model.Mesa;
import com.restaurant.restsys.model.Mesero;
import com.restaurant.restsys.model.Pedido;
import com.restaurant.restsys.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional(readOnly = true)
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Pedido> findByMesa(Mesa mesa) {
        return pedidoRepository.findByMesa(mesa);
    }

    @Transactional(readOnly = true)
    public List<Pedido> findByMesero(Mesero mesero) {
        return pedidoRepository.findByMesero(mesero);
    }

    @Transactional(readOnly = true)
    public List<Pedido> findByEstado(String estado) {
        return pedidoRepository.findByEstado(estado);
    }

    @Transactional(readOnly = true)
    public List<Pedido> findByFechaPedidoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return pedidoRepository.findByFechaPedidoBetween(fechaInicio, fechaFin);
    }

    @Transactional
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Transactional
    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Transactional
    public Pedido update(Long id, Pedido pedido) {
        return pedidoRepository.findById(id)
                .map(existingPedido -> {
                    pedido.setId(id);
                    if (pedido.getEstado() != null) {
                        existingPedido.setEstado(pedido.getEstado());
                    }
                    if (pedido.getObservaciones() != null) {
                        existingPedido.setObservaciones(pedido.getObservaciones());
                    }
                    return pedidoRepository.save(existingPedido);
                })
                .orElse(null);
    }
}