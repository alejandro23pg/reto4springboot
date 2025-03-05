package com.example.demo.service;

import com.example.demo.model.RecursoTurismo;
import com.example.demo.repository.RecursoTurismoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecursoTurismoService {

    private final RecursoTurismoRepository recursoTurismoRepository;

    @Autowired
    public RecursoTurismoService(RecursoTurismoRepository recursoTurismoRepository) {
        this.recursoTurismoRepository = recursoTurismoRepository;
    }

    // Método para obtener todos los recursos
    public List<RecursoTurismo> obtenerTodosLosRecursos() {
        return recursoTurismoRepository.findAll();
    }

    // Método para obtener un recurso por su ID
    public Optional<RecursoTurismo> obtenerRecursoPorId(Long id) {
        return recursoTurismoRepository.findById(id);
    }

    // Método para crear un nuevo recurso
    public RecursoTurismo crearRecurso(RecursoTurismo recurso) {
        return recursoTurismoRepository.save(recurso);
    }

    // Método para actualizar un recurso existente
    public RecursoTurismo actualizarRecurso(Long id, RecursoTurismo recurso) {
        recurso.setId(id);
        return recursoTurismoRepository.save(recurso);
    }

    // Método para eliminar un recurso
    public void eliminarRecurso(Long id) {
        recursoTurismoRepository.deleteById(id);
    }
}
