package com.example.demo.controller;

import com.example.demo.model.RecursoTurismo;
import com.example.demo.repository.RecursoTurismoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para manejar las solicitudes relacionadas con los recursos turísticos.
 * Proporcionará los end-points para realizar operaciones CRUD.
 */
@RestController
@RequestMapping("/recursos")
public class RecursoTurismoController {
    @Autowired
    private RecursoTurismoRepository repository;
    /**
     * Muestra todos los recursos turísticos.
     */
    @GetMapping
    public List<RecursoTurismo> getAllRecursos() {
        return repository.findAll();
    }

    /**
     * Crea un nuevo recurso turístico.
     */
    @PostMapping
    public RecursoTurismo createRecurso(@RequestBody RecursoTurismo recurso) {
        return repository.save(recurso);
    }

    /**
     * Muestra un recurso turístico por su id.
     */
    @GetMapping("/{id}")
    public RecursoTurismo getRecursoById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Actualiza el recurso turístico de la id seleccionada.
     */
    @PutMapping("/{id}")
    public RecursoTurismo updateRecurso(@PathVariable Long id, @RequestBody RecursoTurismo recurso) {
        recurso.setId(id);
        return repository.save(recurso);
    }

    /**
     * Elimina el recurso turístico de la id seleccionada.
     */
    @DeleteMapping("/{id}")
    public void deleteRecurso(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
