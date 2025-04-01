package com.restaurant.restsys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.restsys.model.DetallePedido;
import com.restaurant.restsys.model.Pedido;
import com.restaurant.restsys.model.Producto;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    List<DetallePedido> findByPedido(Pedido pedido);

    List<DetallePedido> findByProducto(Producto producto);
}