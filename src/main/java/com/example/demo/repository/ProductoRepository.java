package com.example.demo.repository;

import com.example.demo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interfaz que proporciona métodos para acceder y manipular la base de datos.
 * Extiende JpaRepository para obtener métodos CRUD básicos.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    /**
     * Busca productos por categoría
     */
    List<Producto> findByCategory(String category);

    /**
     * Busca productos con una calificación mayor o igual a la especificada
     */
    List<Producto> findByRateGreaterThanEqual(Double rate);

    /**
     * Busca productos por título (ignorando mayúsculas y minúsculas)
     */
    List<Producto> findByTitleContainingIgnoreCase(String title);

    /**
     * Busca productos dentro de un rango de precios
     */
    @Query("SELECT p FROM Producto p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Producto> findByPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);

    /**
     * Busca productos con una cantidad de reseñas mayor o igual a la especificada
     */
    List<Producto> findByCountGreaterThanEqual(Integer count);
}
