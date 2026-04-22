package com.duoc.logihub.tracking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "rastreos")
@Data
public class Rastreo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del envío es obligatorio")
    private Long envioId; // Relación con shipping-service

    @NotBlank(message = "La ubicación actual es obligatoria")
    private String ubicacionActual;

    @NotBlank(message = "El detalle del estado es obligatorio")
    private String detalle; // Ejemplo: "En centro de distribución", "Saliendo a reparto"

    private LocalDateTime ultimaActualizacion;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        this.ultimaActualizacion = LocalDateTime.now();
    }
}