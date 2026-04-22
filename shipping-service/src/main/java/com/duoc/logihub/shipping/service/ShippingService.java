package com.duoc.logihub.shipping.service;

import com.duoc.logihub.shipping.model.Envio;
import com.duoc.logihub.shipping.repository.ShippingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private static final Logger logger = LoggerFactory.getLogger(ShippingService.class); // 
    private final ShippingRepository repo;

    public ShippingService(ShippingRepository repo) {
        this.repo = repo;
    }

    public Envio crearEnvio(Envio envio) {
        logger.info("Generando despacho para el pedido ID: {}", envio.getPedidoId()); // [cite: 287]
        envio.setEstadoEnvio("EN_PREPARACION");
        return repo.save(envio);
    }

    public Envio actualizarEstado(Long id, String nuevoEstado) {
        logger.info("Actualizando estado de envío ID: {} a {}", id, nuevoEstado);
        return repo.findById(id).map(e -> {
            e.setEstadoEnvio(nuevoEstado);
            return repo.save(e);
        }).orElse(null);
    }
}