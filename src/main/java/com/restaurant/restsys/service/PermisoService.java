package com.restaurant.restsys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.restsys.model.Permiso;
import com.restaurant.restsys.repository.PermisoRepository;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    @Transactional(readOnly = true)
    public List<Permiso> findAll() {
        return permisoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Permiso> findById(Long id) {
        return permisoRepository.findById(id);
    }

    @Transactional
    public Permiso save(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    @Transactional
    public void deleteById(Long id) {
        permisoRepository.deleteById(id);
    }

    @Transactional
    public Permiso update(Long id, Permiso permiso) {
        if (permisoRepository.existsById(id)) {
            permiso.setId(id);
            return permisoRepository.save(permiso);
        }
        return null;
    }
}