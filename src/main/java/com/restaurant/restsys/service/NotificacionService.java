package com.restaurant.restsys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.restsys.model.Notificacion;
import com.restaurant.restsys.repository.NotificacionRepository;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Transactional(readOnly = true)
    public List<Notificacion> findAll() {
        return notificacionRepository.findByEstado(true);
    }

    @Transactional(readOnly = true)
    public Optional<Notificacion> findById(Long id) {
        return notificacionRepository.findById(id);
    }

    @Transactional
    public Notificacion save(Notificacion notificacion) {
        // Verificar si existe una notificación activa para la mesa
        Optional<Notificacion> notificacionExistente = notificacionRepository
                .findByNumeroMesaAndEstado(notificacion.getNumeroMesa(), true);

        // Si existe una notificación activa, no crear una nueva
        if (notificacionExistente.isPresent()) {
            return notificacionExistente.get();
        }

        // Si no existe una notificación activa, crear la nueva
        return notificacionRepository.save(notificacion);
    }

    @Transactional
    public void deleteById(Long id) {
        notificacionRepository.deleteById(id);
    }

    @Transactional
    public Notificacion update(Long id, Notificacion notificacion) {
        if (notificacionRepository.existsById(id)) {
            notificacion.setId(id);
            return notificacionRepository.save(notificacion);
        }
        return null;
    }

    @Transactional
    public Notificacion marcarComoInactiva(Long id) {
        return notificacionRepository.findById(id)
                .map(notificacion -> {
                    notificacion.setEstado(false);
                    return notificacionRepository.save(notificacion);
                })
                .orElse(null);
    }
}