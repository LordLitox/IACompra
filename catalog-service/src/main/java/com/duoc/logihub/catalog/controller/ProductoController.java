package com.duoc.logihub.catalog.controller;

import com.duoc.logihub.catalog.model.Producto;
import com.duoc.logihub.catalog.service.ProductoService;
import jakarta.validation.Valid; // 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; // 
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // [cite: 228]
@RequestMapping("/api/catalog") // Ruta clara y profesional [cite: 85]
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // 1. Listar todos los productos (GET) [cite: 87, 279]
    @GetMapping
    public ResponseEntity<List<Producto>> getAll() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // 2. Registrar nuevo producto (POST) 
    @PostMapping
    public ResponseEntity<Producto> create(@Valid @RequestBody Producto p) { // 
        Producto nuevo = service.guardar(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo); // Retorna 201 
    }

    // 3. Filtrar por categoría (GET) [cite: 88]
    @GetMapping("/categoria/{cat}")
    public ResponseEntity<List<Producto>> getByCategoria(@PathVariable String cat) {
        List<Producto> productos = service.filtrarPorCategoria(cat);
        return ResponseEntity.ok(productos);
    }
}