package com.duoc.logihub.shipping.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "envios")
@Data
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del pedido es obligatorio")
    private Long pedidoId; // Vinculación con orders-service

    @NotBlank(message = "La dirección de destino es obligatoria")
    private String direccionDestino;

    @NotBlank(message = "El transportista es obligatorio")
    private String transportista; // Ejemplo: ChilePost, LogiBlue

    @NotBlank(message = "El estado del envío es obligatorio")
    private String estadoEnvio; // Ejemplo: EN_PREPARACION, EN_CAMINO, ENTREGADO [cite: 279]
}