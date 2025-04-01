package com.restaurant.restsys.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurant.restsys.dto.ProductoReporteDTO;
import com.restaurant.restsys.model.Mesa;
import com.restaurant.restsys.model.Mesero;
import com.restaurant.restsys.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByMesa(Mesa mesa);

    List<Pedido> findByMesero(Mesero mesero);

    List<Pedido> findByEstado(String estado);

    List<Pedido> findByFechaPedidoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    @Query("SELECT new com.restaurant.restsys.dto.ProductoReporteDTO(dp.producto.id, dp.producto.nombre, " +
            "COUNT(dp) * 100.0 / (SELECT COUNT(dp2) FROM DetallePedido dp2)) " +
            "FROM DetallePedido dp " +
            "GROUP BY dp.producto.id, dp.producto.nombre " +
            "ORDER BY COUNT(dp) DESC " +
            "LIMIT 10")
    List<ProductoReporteDTO> findTop10ProductosMasVendidos();
}