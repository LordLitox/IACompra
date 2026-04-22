package com.duoc.logihub.inventory.controller;

import com.duoc.logihub.inventory.model.Inventario;
import com.duoc.logihub.inventory.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<Integer> getStock(@PathVariable Long productoId) {
        return ResponseEntity.ok(service.obtenerStock(productoId));
    }

    @PostMapping("/update")
    public ResponseEntity<Inventario> update(@Valid @RequestBody Inventario inv) {
        return ResponseEntity.ok(service.actualizarStock(inv.getProductoId(), inv.getCantidad()));
    }
}