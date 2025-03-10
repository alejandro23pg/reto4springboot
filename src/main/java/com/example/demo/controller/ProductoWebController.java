package com.example.demo.controller;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controlador web para gestionar las vistas de los productos
 * El controlador maneja las solicitudes HTTP y devuelve vistas HTML utilizando Thymeleaf
 * Las rutas base comienzan con "/web" para diferenciar la ruta de ProductoController
 */
@Controller
@RequestMapping("/web")
public class ProductoWebController {
    private final ProductoService productoService;

    /**
     * Constructor para inyectar el servicio de productos
     */
    public ProductoWebController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Maneja la solicitud GET para mostrar un listado de todos los productos
     */
    @GetMapping("/productos")
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.obtenerTodosLosProductos());
        return "lista-productos";
    }

    /**
     * Maneja la solicitud GET para mostrar los detalles de un producto específico
     */
    @GetMapping("/productos/{id}")
    public String mostrarProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        model.addAttribute("producto", producto);
        return "detalle-producto";
    }
}