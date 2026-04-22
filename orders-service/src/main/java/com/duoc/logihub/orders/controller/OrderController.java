package com.duoc.logihub.orders.controller;

import com.duoc.logihub.orders.model.Pedido;
import com.duoc.logihub.orders.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Pedido> post(@Valid @RequestBody Pedido p) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearPedido(p));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> getByCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(service.obtenerPedidosPorCliente(clienteId));
    }
}