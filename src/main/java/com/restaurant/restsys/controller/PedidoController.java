package com.restaurant.restsys.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.restsys.dto.PedidoDetalleDTO;
import com.restaurant.restsys.dto.PedidoDetalleDTO.DetallePedidoDTO;
import com.restaurant.restsys.model.Pedido;
import com.restaurant.restsys.service.MesaService;
import com.restaurant.restsys.service.MeseroService;
import com.restaurant.restsys.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private MesaService mesaService;

    @Autowired
    private MeseroService meseroService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id) {
        return pedidoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/mesa/{mesaId}")
    public ResponseEntity<List<Pedido>> findByMesa(@PathVariable Long mesaId) {
        return mesaService.findById(mesaId)
                .map(mesa -> ResponseEntity.ok(pedidoService.findByMesa(mesa)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/mesero/{meseroId}")
    public ResponseEntity<List<Pedido>> findByMesero(@PathVariable Long meseroId) {
        return meseroService.findById(meseroId)
                .map(mesero -> ResponseEntity.ok(pedidoService.findByMesero(mesero)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Pedido>> findByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(pedidoService.findByEstado(estado));
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<Pedido>> findByFechaPedidoBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin) {
        return ResponseEntity.ok(pedidoService.findByFechaPedidoBetween(fechaInicio, fechaFin));
    }

    @GetMapping("/detalles")
    public ResponseEntity<List<PedidoDetalleDTO>> findAllWithDetails() {
        List<Pedido> pedidos = pedidoService.findAll();
        List<PedidoDetalleDTO> pedidosDTO = pedidos.stream()
                .map(pedido -> {
                    PedidoDetalleDTO dto = new PedidoDetalleDTO();
                    dto.setId(pedido.getId());
                    dto.setNumeroMesa(pedido.getMesa().getNumeroMesa());
                    dto.setNombreMesero(pedido.getMesero().getUsuario().getNombre() + " " +
                            pedido.getMesero().getUsuario().getApellido());
                    dto.setEstado(pedido.getEstado());
                    dto.setFechaPedido(pedido.getFechaPedido());
                    dto.setHoraPedido(pedido.getFechaPedido().toLocalTime());
                    dto.setTotal(pedido.getTotal());
                    dto.setObservaciones(pedido.getObservaciones());

                    dto.setDetalles(pedido.getDetalles().stream()
                            .map(detalle -> {
                                DetallePedidoDTO detalleDTO = new DetallePedidoDTO();
                                detalleDTO.setNombreProducto(detalle.getProducto().getNombre());
                                detalleDTO.setCantidad(detalle.getCantidad());
                                detalleDTO.setPrecioUnitario(detalle.getPrecioUnitario());
                                detalleDTO.setSubtotal(detalle.getSubtotal());
                                detalleDTO.setObservaciones(detalle.getObservaciones());
                                return detalleDTO;
                            })
                            .collect(Collectors.toList()));

                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(pedidosDTO);
    }

    @GetMapping("/detalles/fecha/{fecha}")
    public ResponseEntity<List<PedidoDetalleDTO>> findWithDetailsByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        LocalDateTime inicioDia = fecha.atStartOfDay();
        LocalDateTime finDia = fecha.atTime(LocalTime.MAX);

        List<Pedido> pedidos = pedidoService.findByFechaPedidoBetween(inicioDia, finDia);
        List<PedidoDetalleDTO> pedidosDTO = pedidos.stream()
                .map(pedido -> {
                    PedidoDetalleDTO dto = new PedidoDetalleDTO();
                    dto.setId(pedido.getId());
                    dto.setNumeroMesa(pedido.getMesa().getNumeroMesa());
                    dto.setNombreMesero(pedido.getMesero().getUsuario().getNombre() + " " +
                            pedido.getMesero().getUsuario().getApellido());
                    dto.setEstado(pedido.getEstado());
                    dto.setFechaPedido(pedido.getFechaPedido());
                    dto.setHoraPedido(pedido.getFechaPedido().toLocalTime());
                    dto.setTotal(pedido.getTotal());
                    dto.setObservaciones(pedido.getObservaciones());

                    dto.setDetalles(pedido.getDetalles().stream()
                            .map(detalle -> {
                                DetallePedidoDTO detalleDTO = new DetallePedidoDTO();
                                detalleDTO.setNombreProducto(detalle.getProducto().getNombre());
                                detalleDTO.setCantidad(detalle.getCantidad());
                                detalleDTO.setPrecioUnitario(detalle.getPrecioUnitario());
                                detalleDTO.setSubtotal(detalle.getSubtotal());
                                detalleDTO.setObservaciones(detalle.getObservaciones());
                                return detalleDTO;
                            })
                            .collect(Collectors.toList()));

                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(pedidosDTO);
    }

    @GetMapping("/detalles/ultimos-dias/{dias}")
    public ResponseEntity<List<PedidoDetalleDTO>> findWithDetailsLastDays(@PathVariable int dias) {
        LocalDateTime fechaFin = LocalDateTime.now();
        LocalDateTime fechaInicio = fechaFin.minus(dias, ChronoUnit.DAYS);

        List<Pedido> pedidos = pedidoService.findByFechaPedidoBetween(fechaInicio, fechaFin);
        List<PedidoDetalleDTO> pedidosDTO = pedidos.stream()
                .map(pedido -> {
                    PedidoDetalleDTO dto = new PedidoDetalleDTO();
                    dto.setId(pedido.getId());
                    dto.setNumeroMesa(pedido.getMesa().getNumeroMesa());
                    dto.setNombreMesero(pedido.getMesero().getUsuario().getNombre() + " " +
                            pedido.getMesero().getUsuario().getApellido());
                    dto.setEstado(pedido.getEstado());
                    dto.setFechaPedido(pedido.getFechaPedido());
                    dto.setHoraPedido(pedido.getFechaPedido().toLocalTime());
                    dto.setTotal(pedido.getTotal());
                    dto.setObservaciones(pedido.getObservaciones());

                    dto.setDetalles(pedido.getDetalles().stream()
                            .map(detalle -> {
                                DetallePedidoDTO detalleDTO = new DetallePedidoDTO();
                                detalleDTO.setNombreProducto(detalle.getProducto().getNombre());
                                detalleDTO.setCantidad(detalle.getCantidad());
                                detalleDTO.setPrecioUnitario(detalle.getPrecioUnitario());
                                detalleDTO.setSubtotal(detalle.getSubtotal());
                                detalleDTO.setObservaciones(detalle.getObservaciones());
                                return detalleDTO;
                            })
                            .collect(Collectors.toList()));

                    return dto;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(pedidosDTO);
    }

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.save(pedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedido) {
        Pedido updatedPedido = pedidoService.update(id, pedido);
        return updatedPedido != null ? ResponseEntity.ok(updatedPedido) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        pedidoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}