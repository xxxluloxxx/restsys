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
        return notificacionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Notificacion> findById(Long id) {
        return notificacionRepository.findById(id);
    }

    @Transactional
    public Notificacion save(Notificacion notificacion) {
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
}