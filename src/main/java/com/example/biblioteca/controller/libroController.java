package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.libro;
import com.example.biblioteca.service.libroService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/libros")
public class libroController {
    
    
    private final libroService libroService;
    
    @Autowired
    public libroController(libroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
        public ResponseEntity<List<libro>> getAll() {
            return ResponseEntity.ok(libroService.getAll());
        }
    
    @PostMapping
    public ResponseEntity<libro> guardarLibro(@RequestBody libro libro) {
        return ResponseEntity.ok(libroService.guardarLibro(libro));
    }
    


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable int id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.ok().build();
    }

     @PutMapping("/{id}")
    public ResponseEntity<?> actualizarLibro(@PathVariable int id, @Valid @RequestBody libro libro) {
        try {
            libro libroActualizado = libroService.actualizarLibro(id, libro);
            return new ResponseEntity<>(libroActualizado, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return    ResponseEntity.status(HttpStatus.NOT_FOUND).body("El libro con id " + id + " no existe");
        }
    }

}
