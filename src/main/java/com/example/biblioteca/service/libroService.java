package com.example.biblioteca.service;

import java.util.List;
import java.util.Optional;

import com.example.biblioteca.model.libro;

public interface libroService {
    
    List<libro> getAll();
    Optional<libro> findById(int id);
    libro guardarLibro(libro libro);
    void eliminarLibro(int id);
    libro  actualizarLibro(int id, libro libro);
}
