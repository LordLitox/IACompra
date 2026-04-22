package com.duoc.logihub.tracking.service;

import com.duoc.logihub.tracking.model.Rastreo;
import com.duoc.logihub.tracking.repository.TrackingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrackingService {

    private static final Logger logger = LoggerFactory.getLogger(TrackingService.class);
    private final TrackingRepository repo;

    public TrackingService(TrackingRepository repo) {
        this.repo = repo;
    }

    public Rastreo registrarMovimiento(Rastreo rastreo) {
        logger.info("Registrando nuevo movimiento para el envío ID: {}", rastreo.getEnvioId());
        return repo.save(rastreo);
    }

    public List<Rastreo> obtenerHistorial(Long envioId) {
        logger.info("Consultando historial de rastreo para envío ID: {}", envioId);
        return repo.findByEnvioIdOrderByUltimaActualizacionDesc(envioId);
    }
}