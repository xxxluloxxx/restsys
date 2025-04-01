package com.restaurant.restsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restsys.model.DetallePedido;
import com.restaurant.restsys.service.DetallePedidoService;
import com.restaurant.restsys.service.PedidoService;
import com.restaurant.restsys.service.ProductoService;

@RestController
@RequestMapping("/api/detalles-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<DetallePedido>> findAll() {
        return ResponseEntity.ok(detallePedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> findById(@PathVariable Long id) {
        return detallePedidoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pedido/{pedidoId}")
    public ResponseEntity<List<DetallePedido>> findByPedido(@PathVariable Long pedidoId) {
        return pedidoService.findById(pedidoId)
                .map(pedido -> ResponseEntity.ok(detallePedidoService.findByPedido(pedido)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/producto/{productoId}")
    public ResponseEntity<List<DetallePedido>> findByProducto(@PathVariable Long productoId) {
        return productoService.findById(productoId)
                .map(producto -> ResponseEntity.ok(detallePedidoService.findByProducto(producto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DetallePedido> create(@RequestBody DetallePedido detallePedido) {
        return ResponseEntity.ok(detallePedidoService.save(detallePedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> update(@PathVariable Long id, @RequestBody DetallePedido detallePedido) {
        DetallePedido updatedDetallePedido = detallePedidoService.update(id, detallePedido);
        return updatedDetallePedido != null ? ResponseEntity.ok(updatedDetallePedido)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        detallePedidoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}