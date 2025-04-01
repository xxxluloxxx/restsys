package com.restaurant.restsys.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/menu1")
    public ResponseEntity<?> getMenu1() {
        try {
            File menuFile = new File("menu1.json");
            Object menu = objectMapper.readValue(menuFile, Object.class);
            return ResponseEntity.ok(menu);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error al leer el archivo menu1.json");
        }
    }

    @GetMapping("/menu2")
    public ResponseEntity<?> getMenu2() {
        try {
            File menuFile = new File("menu2.json");
            Object menu = objectMapper.readValue(menuFile, Object.class);
            return ResponseEntity.ok(menu);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error al leer el archivo menu2.json");
        }
    }
}