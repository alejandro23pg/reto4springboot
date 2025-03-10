package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que proporciona la lógica de negocio para los productos.
 */
@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    /**
     * Obtiene todos los productos
     */
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    /**
     * Obtiene un producto por su id
     */
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    /**
     * Crea un nuevo producto
     */
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    /**
     * Actualiza un producto existente
     */
    public Producto actualizarProducto(Long id, Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    /**
     * Elimina un producto por su ID
     */
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    /**
     * Busca productos por categoría
     */
    public List<Producto> buscarPorCategoria(String category) {
        return productoRepository.findByCategory(category);
    }

    /**
     * Busca productos con una calificación mayor o igual a la especificada
     */
    public List<Producto> buscarPorCalificacionMinima(Double rate) {
        return productoRepository.findByRateGreaterThanEqual(rate);
    }

    /**
     * Busca productos por título (ignorando mayúsculas y minúsculas)
     * @return Lista de productos que coinciden con el título.
     */
    public List<Producto> buscarPorTitulo(String title) {
        return productoRepository.findByTitleContainingIgnoreCase(title);
    }

    /**
     * Busca productos dentro de un rango de precios
     */
    public List<Producto> buscarPorRangoDePrecio(Double minPrice, Double maxPrice) {
        return productoRepository.findByPriceRange(minPrice, maxPrice);
    }

    /**
     * Busca productos con una cantidad de reseñas mayor o igual a la especificada
     */
    public List<Producto> buscarPorCantidadDeResenas(Integer count) {
        return productoRepository.findByCountGreaterThanEqual(count);
    }
}
