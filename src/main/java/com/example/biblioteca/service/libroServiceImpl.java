package com.example.biblioteca.service;

import com.example.biblioteca.model.libro;
import com.example.biblioteca.repository.libroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class libroServiceImpl implements libroService {

    private final libroRepository libroRepository;

    @Autowired
    public libroServiceImpl(libroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }
    

    @Override
    @Transactional(readOnly = true)
    public List<libro> getAll() {
        return libroRepository.findAll();
    }


    @Override
    @Transactional
    public libro guardarLibro(libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    @Transactional
    public libro actualizarLibro(int id, libro libroActualizado) {
        libro libroExistente = libroRepository.findById(id).orElse(null);
        
        if (libroExistente != null) {
            libroExistente.setTitulo(libroActualizado.getTitulo());
            libroExistente.setAutor(libroActualizado.getAutor());
            libroExistente.setAnio(libroActualizado.getAnio());
            libroExistente.setGenero(libroActualizado.getGenero());
            return libroRepository.save(libroExistente);
        }
        
        return null;
    }

    @Override
    @Transactional
    public void eliminarLibro(int id) {
        if (!libroRepository.existsById(id)) {
            throw new RuntimeException("El libro con id " + id + " no existe");
        }
        libroRepository.deleteById(id);
    }


  @Override
  @Transactional(readOnly = true)
    public Optional<libro> findById(int id) {
        return libroRepository.findById(id);
    }

}