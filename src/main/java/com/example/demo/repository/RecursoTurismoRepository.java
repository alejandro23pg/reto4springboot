package com.example.demo.repository;

import com.example.demo.model.RecursoTurismo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que proporciona métodos para acceder y manipular la base de datos.
 */
public interface RecursoTurismoRepository extends JpaRepository<RecursoTurismo, Long> {
}
