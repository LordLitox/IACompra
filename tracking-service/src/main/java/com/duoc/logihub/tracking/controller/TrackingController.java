package com.duoc.logihub.tracking.controller;

import com.duoc.logihub.tracking.model.Rastreo;
import com.duoc.logihub.tracking.service.TrackingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    private final TrackingService service;

    public TrackingController(TrackingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Rastreo> post(@Valid @RequestBody Rastreo r) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarMovimiento(r));
    }

    @GetMapping("/{envioId}")
    public ResponseEntity<List<Rastreo>> getHistory(@PathVariable Long envioId) {
        return ResponseEntity.ok(service.obtenerHistorial(envioId));
    }
}