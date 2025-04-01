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

import com.restaurant.restsys.dto.MeseroDTO;
import com.restaurant.restsys.model.Mesero;
import com.restaurant.restsys.service.MeseroService;
import com.restaurant.restsys.service.UsuarioService;

@RestController
@RequestMapping("/api/meseros")
public class MeseroController {

    @Autowired
    private MeseroService meseroService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Mesero>> findAll() {
        return ResponseEntity.ok(meseroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeseroDTO> findById(@PathVariable Long id) {
        return meseroService.findById(id)
                .map(mesero -> {
                    MeseroDTO dto = new MeseroDTO();
                    dto.setId(mesero.getId());
                    dto.setUsuarioId(mesero.getUsuario().getId());
                    dto.setUsuarioNombres(mesero.getUsuario().getNombre() + " " + mesero.getUsuario().getApellido());
                    return ResponseEntity.ok(dto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Mesero> findByUsuario(@PathVariable Long usuarioId) {
        return usuarioService.findById(usuarioId)
                .flatMap(usuario -> meseroService.findByUsuario(usuario))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Mesero>> findByEstado(@PathVariable String estado) {
        return ResponseEntity.ok(meseroService.findByEstado(estado));
    }

    @PostMapping
    public ResponseEntity<Mesero> create(@RequestBody Mesero mesero) {
        return ResponseEntity.ok(meseroService.save(mesero));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesero> update(@PathVariable Long id, @RequestBody Mesero mesero) {
        Mesero updatedMesero = meseroService.update(id, mesero);
        return updatedMesero != null ? ResponseEntity.ok(updatedMesero) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        meseroService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}