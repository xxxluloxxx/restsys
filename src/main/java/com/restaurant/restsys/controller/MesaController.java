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

import com.restaurant.restsys.model.Mesa;
import com.restaurant.restsys.service.MesaService;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public ResponseEntity<List<Mesa>> findAll() {
        return ResponseEntity.ok(mesaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> findById(@PathVariable Long id) {
        return mesaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/numero/{numeroMesa}")
    public ResponseEntity<Mesa> findByNumeroMesa(@PathVariable Integer numeroMesa) {
        return mesaService.findByNumeroMesa(numeroMesa)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Mesa>> findByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(mesaService.findByEstado(estado));
    }

    @PostMapping
    public ResponseEntity<Mesa> create(@RequestBody Mesa mesa) {
        return ResponseEntity.ok(mesaService.save(mesa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> update(@PathVariable Long id, @RequestBody Mesa mesa) {
        Mesa updatedMesa = mesaService.update(id, mesa);
        return updatedMesa != null ? ResponseEntity.ok(updatedMesa) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mesaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}