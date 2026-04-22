package com.duoc.logihub.notifications.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificaciones")
@Data
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El destinatario es obligatorio")
    @Email(message = "Debe ser un correo válido")
    private String destinatario;

    @NotBlank(message = "El mensaje no puede estar vacío")
    private String mensaje;

    private String tipo; // Ejemplo: EMAIL, SMS, PUSH

    private LocalDateTime fechaEnvio;

    @PrePersist
    protected void onCreate() {
        this.fechaEnvio = LocalDateTime.now();
    }
}