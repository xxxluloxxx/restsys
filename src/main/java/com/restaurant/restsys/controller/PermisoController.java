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

import com.restaurant.restsys.model.Permiso;
import com.restaurant.restsys.service.PermisoService;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @GetMapping
    public ResponseEntity<List<Permiso>> findAll() {
        return ResponseEntity.ok(permisoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permiso> findById(@PathVariable Long id) {
        return permisoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Permiso> create(@RequestBody Permiso permiso) {
        return ResponseEntity.ok(permisoService.save(permiso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Permiso> update(@PathVariable Long id, @RequestBody Permiso permiso) {
        Permiso updatedPermiso = permisoService.update(id, permiso);
        return updatedPermiso != null ? ResponseEntity.ok(updatedPermiso) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        permisoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}