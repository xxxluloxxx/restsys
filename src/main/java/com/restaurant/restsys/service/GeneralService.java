package com.restaurant.restsys.service;

import com.restaurant.restsys.model.General;
import com.restaurant.restsys.repository.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GeneralService {

    @Autowired
    private GeneralRepository generalRepository;

    @Transactional(readOnly = true)
    public List<General> findAll() {
        return generalRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<General> findById(Long id) {
        return generalRepository.findById(id);
    }

    @Transactional
    public General save(General general) {
        return generalRepository.save(general);
    }

    @Transactional
    public void deleteById(Long id) {
        generalRepository.deleteById(id);
    }

    @Transactional
    public General update(Long id, General general) {
        if (generalRepository.existsById(id)) {
            general.setId(id);
            return generalRepository.save(general);
        }
        return null;
    }
} 