package com.duoc.logihub.orders.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId; // Relación con users-service

    @NotNull(message = "El ID del producto es obligatorio")
    private Long productoId; // Relación con catalog-service

    @Min(value = 1, message = "La cantidad mínima es 1")
    private int cantidad;

    private double total;

    @NotBlank(message = "El estado es obligatorio")
    private String estado; // Ejemplo: PENDIENTE, PAGADO, ENVIADO

    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
        if (this.estado == null) this.estado = "PENDIENTE";
    }
}