package com.example.biblioteca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "libro")
public class libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El título es obligatorio")
    @Size(min = 1, max = 200, message = "El título debe tener entre 1 y 200 caracteres")
    private String titulo;
    
    @NotBlank(message = "El autor es obligatorio")
    @Size(min = 1, max = 200, message = "El autor debe tener entre 1 y 200 caracteres")
    private String autor;
    
    @NotBlank(message = "El genero es obligatorio")
    @Size(min = 1, max = 200, message = "El genero debe tener entre 1 y 200 caracteres")
    private String genero;
    
    @NotNull(message = "El año de publicación es obligatorio")
    @PastOrPresent(message = "El año de publicación no puede ser futuro")
    private int anio;
    
    @NotBlank(message = "El editorial es obligatorio")
    @Size(min = 1, max = 200, message = "El título debe tener entre 1 y 200 caracteres")
    private String editorial;

    // Constructor vacío
    public libro() {
    }

    // Constructor con todos los campos
    public libro(int id, String titulo, String autor, String genero, int anio, String editorial) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
        this.editorial = editorial;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }


    @Override
    public String toString() {
        return "libro [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero + ", anio=" + anio
                + ", editorial=" + editorial + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        libro other = (libro) obj;
        if (id != other.id)
            return false;
        return true;
    }
}