package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * La clase Producto representa los productos de la API.
 * Esta clase es una entidad JPA que se mapea a una tabla en la base de datos.
 */
@Entity
public class Producto {

    /**
     * Identificador único para cada producto. Se generará automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Título del producto.
     */
    private String title;

    /**
     * Precio del producto.
     */
    private Double price;

    /**
     * Descripción del producto.
     */
    private String description;

    /**
     * Categoría del producto.
     */
    private String category;

    /**
     * URL de la imagen del producto.
     */
    private String image;

    /**
     * Calificación del producto.
     */
    private Double rate;

    /**
     * Cantidad de reseñas del producto.
     */
    private Integer count;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
