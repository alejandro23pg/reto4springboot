package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * La clase RecursoTurismo representa los distintos recursos de la API.
 * Esta clase es una entidad JPA que se mapea a una tabla en la base de datos.
 */
@Entity
public class RecursoTurismo {
    /**
     * Identificador único para cada recurso turístico. Se generará automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nombre del recurso turístico.
     */
    private String nombre;
    /**
     * Descripción del recurso turístico.
     */
    private String descripcion;
    /**
     * Ubicación del recurso turístico (provincia).
     */
    private String ubicacion;

    /**
     * Categoría el recurso turístico.
     */

    private String categoria;
    /**
     * Obtiene el identificador único del recurso turístico.
     */
    public Long getId() {
        return id;
    }
    /**
     * Establece el identificador único del recurso turístico.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Obtiene el nombre del recurso turístico.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del recurso turístico.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene la descripción del recurso turístico.
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Establece la descripción del recurso turístico.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Obtiene la ubicación del recurso turístico.
     */
    public String getUbicacion() {
        return ubicacion;
    }
    /**
     * Establece la ubicación del recurso turístico.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    /**
     * Obtiene la categoría del recurso turístico.
     */
    public String getCategoria() {
        return categoria;
    }
    /**
     * Establece la categoría del recurso turístico.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
