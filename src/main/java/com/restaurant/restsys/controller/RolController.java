package com.restaurant.restsys.controller;

import java.util.List;
import java.util.Set;

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
import com.restaurant.restsys.model.Rol;
import com.restaurant.restsys.service.RolService;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> findAll() {
        return ResponseEntity.ok(rolService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> findById(@PathVariable Long id) {
        return rolService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rol> create(@RequestBody Rol rol) {
        return ResponseEntity.ok(rolService.save(rol));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> update(@PathVariable Long id, @RequestBody Rol rol) {
        Rol updatedRol = rolService.update(id, rol);
        return updatedRol != null ? ResponseEntity.ok(updatedRol) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rolService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/permisos")
    public ResponseEntity<Set<Permiso>> getPermisos(@PathVariable Long id) {
        Set<Permiso> permisos = rolService.getPermisosByRolId(id);
        return permisos != null ? ResponseEntity.ok(permisos) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/permisos")
    public ResponseEntity<Rol> asignarPermisos(@PathVariable Long id, @RequestBody Set<Permiso> permisos) {
        Rol updatedRol = rolService.asignarPermisos(id, permisos);
        return updatedRol != null ? ResponseEntity.ok(updatedRol) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/permisos/{permisoId}")
    public ResponseEntity<Rol> agregarPermiso(@PathVariable Long id, @PathVariable Long permisoId) {
        Permiso permiso = new Permiso();
        permiso.setId(permisoId);
        Rol updatedRol = rolService.agregarPermiso(id, permiso);
        return updatedRol != null ? ResponseEntity.ok(updatedRol) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}/permisos/{permisoId}")
    public ResponseEntity<Rol> eliminarPermiso(@PathVariable Long id, @PathVariable Long permisoId) {
        Rol updatedRol = rolService.eliminarPermiso(id, permisoId);
        return updatedRol != null ? ResponseEntity.ok(updatedRol) : ResponseEntity.notFound().build();
    }
}