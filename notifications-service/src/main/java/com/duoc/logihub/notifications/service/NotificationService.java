package com.duoc.logihub.notifications.service;

import com.duoc.logihub.notifications.model.Notificacion;
import com.duoc.logihub.notifications.repository.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class); 
    
    private final NotificationRepository repo;

    public NotificationService(NotificationRepository repo) {
        this.repo = repo;
    }

    public Notificacion enviarNotificacion(Notificacion n) {
        logger.info("Enviando notificación de tipo {} a: {}", n.getTipo(), n.getDestinatario());
        // Aquí se integraría un servicio real de Mail o SMS
        return repo.save(n);
    }
}