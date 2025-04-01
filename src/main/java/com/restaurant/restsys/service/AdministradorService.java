package com.restaurant.restsys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.restsys.model.Administrador;
import com.restaurant.restsys.repository.AdministradorRepository;
import com.restaurant.restsys.util.DateTimeUtil;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Transactional(readOnly = true)
    public List<Administrador> findAll() {
        return administradorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Administrador> findById(Long id) {
        return administradorRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Administrador> findByEmail(String email) {
        return administradorRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public Optional<Administrador> findByNumeroDocumento(String numeroDocumento) {
        return administradorRepository.findByNumeroDocumento(numeroDocumento);
    }

    @Transactional(readOnly = true)
    public Optional<Administrador> findByEmailAndPassword(String email, String password) {
        return administradorRepository.findByEmail(email)
                .filter(administrador -> administrador.getPassword().equals(password) &&
                        administrador.getEstado())
                .map(administrador -> {
                    administrador.setUltimoAcceso(DateTimeUtil.getCurrentDateTime());
                    return administradorRepository.save(administrador);
                });
    }

    @Transactional
    public Administrador save(Administrador administrador) {
        return administradorRepository.save(administrador);
    }

    @Transactional
    public void deleteById(Long id) {
        administradorRepository.deleteById(id);
    }

    @Transactional
    public Administrador update(Long id, Administrador administrador) {
        if (administradorRepository.existsById(id)) {
            administrador.setId(id);
            return administradorRepository.save(administrador);
        }
        return null;
    }
}