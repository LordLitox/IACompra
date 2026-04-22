package com.duoc.logihub.reviews.controller;

import com.duoc.logihub.reviews.model.Resena;
import com.duoc.logihub.reviews.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Resena> post(@Valid @RequestBody Resena r) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.publicarResena(r));
    }

    @GetMapping("/producto/{productoId}")
    public ResponseEntity<List<Resena>> getByProducto(@PathVariable Long productoId) {
        return ResponseEntity.ok(service.obtenerPorProducto(productoId));
    }
}