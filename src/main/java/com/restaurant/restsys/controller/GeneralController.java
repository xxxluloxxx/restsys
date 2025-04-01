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

import com.restaurant.restsys.model.General;
import com.restaurant.restsys.service.GeneralService;

@RestController
@RequestMapping("/api/general")
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @GetMapping
    public ResponseEntity<List<General>> findAll() {
        return ResponseEntity.ok(generalService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<General> findById(@PathVariable Long id) {
        return generalService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<General> create(@RequestBody General general) {
        return ResponseEntity.ok(generalService.save(general));
    }

    @PutMapping("/{id}")
    public ResponseEntity<General> update(@PathVariable Long id, @RequestBody General general) {
        General updatedGeneral = generalService.update(id, general);
        return updatedGeneral != null ? ResponseEntity.ok(updatedGeneral) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        generalService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}