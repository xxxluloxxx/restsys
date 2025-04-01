package com.restaurant.restsys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.restsys.model.Mesero;
import com.restaurant.restsys.model.Usuario;
import com.restaurant.restsys.repository.MeseroRepository;

@Service
public class MeseroService {

    @Autowired
    private MeseroRepository meseroRepository;

    @Transactional(readOnly = true)
    public List<Mesero> findAll() {
        return meseroRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Mesero> findById(Long id) {
        return meseroRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Mesero> findByUsuario(Usuario usuario) {
        return meseroRepository.findByUsuario(usuario);
    }

    @Transactional(readOnly = true)
    public List<Mesero> findByEstado(String estado) {
        return meseroRepository.findByEstado(estado);
    }

    @Transactional
    public Mesero save(Mesero mesero) {
        return meseroRepository.save(mesero);
    }

    @Transactional
    public void deleteById(Long id) {
        meseroRepository.deleteById(id);
    }

    @Transactional
    public Mesero update(Long id, Mesero mesero) {
        if (meseroRepository.existsById(id)) {
            mesero.setId(id);
            return meseroRepository.save(mesero);
        }
        return null;
    }
}