package com.duoc.logihub.payments.service;

import com.duoc.logihub.payments.model.Pago;
import com.duoc.logihub.payments.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);
    private final PaymentRepository repo;

    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }

    public Pago procesarPago(Pago pago) {
        logger.info("Procesando pago para el pedido ID: {} por un monto de {}", pago.getPedidoId(), pago.getMonto());
        
        // Simulación de lógica de negocio: aprobamos si el monto es menor a 100.000
        if (pago.getMonto() > 0 && pago.getMonto() < 100000) {
            pago.setEstado("APROBADO");
            logger.info("Transacción aprobada para pedido ID: {}", pago.getPedidoId());
        } else {
            pago.setEstado("RECHAZADO");
            logger.warn("Transacción rechazada: Monto excede el límite permitido");
        }
        
        return repo.save(pago);
    }
}