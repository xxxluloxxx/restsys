package com.restaurant.restsys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.restsys.model.Mesa;
import com.restaurant.restsys.repository.MesaRepository;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Transactional(readOnly = true)
    public List<Mesa> findAll() {
        return mesaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Mesa> findById(Long id) {
        return mesaRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Mesa> findByNumeroMesa(Integer numeroMesa) {
        return mesaRepository.findByNumeroMesa(numeroMesa);
    }

    @Transactional(readOnly = true)
    public List<Mesa> findByEstado(String estado) {
        return mesaRepository.findByEstado(estado);
    }

    @Transactional
    public Mesa save(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    @Transactional
    public void deleteById(Long id) {
        mesaRepository.deleteById(id);
    }

    @Transactional
    public Mesa update(Long id, Mesa mesa) {
        if (mesaRepository.existsById(id)) {
            mesa.setId(id);
            return mesaRepository.save(mesa);
        }
        return null;
    }
}