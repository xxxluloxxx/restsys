package com.restaurant.restsys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.restsys.model.Categoria;
import com.restaurant.restsys.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Categoria> findByNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }

    @Transactional
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Transactional
    public Categoria update(Long id, Categoria categoria) {
        return categoriaRepository.findById(id)
                .map(existingCategoria -> {
                    categoria.setId(id);
                    categoria.setCreatedAt(existingCategoria.getCreatedAt());
                    return categoriaRepository.save(categoria);
                })
                .orElse(null);
    }
}