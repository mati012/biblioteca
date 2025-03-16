package com.example.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biblioteca.model.libro;

import java.util.List;

@Repository
public interface libroRepository extends JpaRepository<libro, Integer> {
    List<libro> findByTituloContainingIgnoreCase(String titulo);
    
    List<libro> findByAutorContainingIgnoreCase(String autor);
    
    List<libro> findByGeneroIgnoreCase(String genero);
    
    List<libro> findByAnio(Integer anio);
    
}
