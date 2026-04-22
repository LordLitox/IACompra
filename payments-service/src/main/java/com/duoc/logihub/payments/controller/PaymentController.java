package com.duoc.logihub.payments.controller;

import com.duoc.logihub.payments.model.Pago;
import com.duoc.logihub.payments.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping("/process")
    public ResponseEntity<Pago> process(@Valid @RequestBody Pago p) {
        Pago resultado = service.procesarPago(p);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }
}