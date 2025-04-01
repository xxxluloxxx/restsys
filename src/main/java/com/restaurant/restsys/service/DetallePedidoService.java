package com.restaurant.restsys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.restsys.model.DetallePedido;
import com.restaurant.restsys.model.Pedido;
import com.restaurant.restsys.model.Producto;
import com.restaurant.restsys.repository.DetallePedidoRepository;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Transactional(readOnly = true)
    public List<DetallePedido> findAll() {
        return detallePedidoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<DetallePedido> findById(Long id) {
        return detallePedidoRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<DetallePedido> findByPedido(Pedido pedido) {
        return detallePedidoRepository.findByPedido(pedido);
    }

    @Transactional(readOnly = true)
    public List<DetallePedido> findByProducto(Producto producto) {
        return detallePedidoRepository.findByProducto(producto);
    }

    @Transactional
    public DetallePedido save(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Transactional
    public void deleteById(Long id) {
        detallePedidoRepository.deleteById(id);
    }

    @Transactional
    public DetallePedido update(Long id, DetallePedido detallePedido) {
        if (detallePedidoRepository.existsById(id)) {
            detallePedido.setId(id);
            return detallePedidoRepository.save(detallePedido);
        }
        return null;
    }
}