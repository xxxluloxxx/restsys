package com.restaurant.restsys.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.restsys.model.Permiso;
import com.restaurant.restsys.model.Rol;
import com.restaurant.restsys.repository.RolRepository;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    @Transactional(readOnly = true)
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }

    @Transactional
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Transactional
    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }

    @Transactional
    public Rol update(Long id, Rol rol) {
        if (rolRepository.existsById(id)) {
            rol.setId(id);
            return rolRepository.save(rol);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Set<Permiso> getPermisosByRolId(Long rolId) {
        return rolRepository.findById(rolId)
                .map(Rol::getPermisos)
                .orElse(null);
    }

    @Transactional
    public Rol asignarPermisos(Long rolId, Set<Permiso> permisos) {
        return rolRepository.findById(rolId)
                .map(rol -> {
                    rol.setPermisos(permisos);
                    return rolRepository.save(rol);
                })
                .orElse(null);
    }

    @Transactional
    public Rol agregarPermiso(Long rolId, Permiso permiso) {
        return rolRepository.findById(rolId)
                .map(rol -> {
                    rol.getPermisos().add(permiso);
                    return rolRepository.save(rol);
                })
                .orElse(null);
    }

    @Transactional
    public Rol eliminarPermiso(Long rolId, Long permisoId) {
        return rolRepository.findById(rolId)
                .map(rol -> {
                    rol.getPermisos().removeIf(permiso -> permiso.getId().equals(permisoId));
                    return rolRepository.save(rol);
                })
                .orElse(null);
    }
}