package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador para manejar las solicitudes relacionadas con los productos
 * Proporciona endpoints para realizar operaciones CRUD sobre los productos
 */
@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository repository;

    /**
     * Obtiene todos los productos
     */
    @GetMapping
    public List<Producto> getAllProductos() {
        return repository.findAll();
    }

    /**
     * Crea un nuevo producto
     */
    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return repository.save(producto);
    }

    /**
     * Obtiene un producto por su ID
     */
    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Actualiza un producto existente
     */
    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId(id);
        return repository.save(producto);
    }

    /**
     * Elimina un producto por su ID
     */
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
