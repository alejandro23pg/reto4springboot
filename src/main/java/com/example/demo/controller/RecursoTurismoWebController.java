package com.example.demo.controller;

import com.example.demo.model.RecursoTurismo;
import com.example.demo.service.RecursoTurismoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador web para gestionar las vistas de los los recursos turísticos
 * El controlador maneja las solicitudes HTTP y devuelve vistas HTML utilizando Thymeleaf
 * Las rutas base comienzan con "/web" para diferenciar la ruta de RecursoTurismoController
 */
@Controller
@RequestMapping("/web")
public class RecursoTurismoWebController {
    private final RecursoTurismoService recursoTurismoService;

    /**
     * Constructor para inyectar el servicio de recursos turísticos
     * @param recursoTurismoService El servicio que proporciona la lógica de negocio para los recursos turísticos
     */
    public RecursoTurismoWebController(RecursoTurismoService recursoTurismoService) {
        this.recursoTurismoService = recursoTurismoService;
    }

    /**
     * Maneja la solicitud GET para mostrar un listado de todos los recursos turísticos
     * La vista devuelta es "lista-recursos", que muestra los recursos en una tabla
     * @param model El modelo que se pasa a la vista para agregar atributos
     * @return El nombre de la vista Thymeleaf que muestra el listado de recursos
     */
    @GetMapping("/recursos")
    public String listarRecursos(Model model) {
        model.addAttribute("recursos", recursoTurismoService.obtenerTodosLosRecursos());
        return "lista-recursos";
    }

    /**
     * Maneja la solicitud GET para mostrar los detalles de un recurso turístico específico
     * La vista devuelta es "detalle-recurso", que muestra los detalles del recurso
     * @param id es el identificador único del recurso turístico
     * @param model es el modelo que se pasa a la vista para agregar atributos
     * @return devuelve el nombre de la vista que muestra los detalles del recurso
     */
    @GetMapping("/recursos/{id}")
    public String mostrarRecurso(@PathVariable Long id, Model model) {
        RecursoTurismo recurso = recursoTurismoService.obtenerRecursoPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Recurso no encontrado"));
        model.addAttribute("recurso", recurso);
        return "detalle-recurso";
    }
}