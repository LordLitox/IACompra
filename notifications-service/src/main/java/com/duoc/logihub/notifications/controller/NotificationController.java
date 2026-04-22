package com.duoc.logihub.notifications.controller;

import com.duoc.logihub.notifications.model.Notificacion;
import com.duoc.logihub.notifications.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public ResponseEntity<Notificacion> send(@Valid @RequestBody Notificacion n) { // [cite: 281]
        return ResponseEntity.status(HttpStatus.CREATED).body(service.enviarNotificacion(n));
    }
}
