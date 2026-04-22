package com.duoc.logihub.shipping.controller;

import com.duoc.logihub.shipping.model.Envio;
import com.duoc.logihub.shipping.service.ShippingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    private final ShippingService service;

    public ShippingController(ShippingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Envio> create(@Valid @RequestBody Envio envio) { // [cite: 281]
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearEnvio(envio));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Envio> updateStatus(@PathVariable Long id, @RequestParam String status) {
        Envio actualizado = service.actualizarEstado(id, status);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }
}