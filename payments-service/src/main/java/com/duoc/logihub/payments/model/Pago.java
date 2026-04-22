package com.duoc.logihub.payments.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "pagos")
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del pedido es obligatorio")
    private Long pedidoId; // Relación con el microservicio de órdenes [cite: 111]

    @Min(value = 1, message = "El monto debe ser positivo")
    private double monto;

    @NotBlank(message = "El método de pago es obligatorio")
    private String metodo; // Ejemplo: TARJETA, TRANSFERENCIA

    @NotBlank(message = "El estado no puede estar vacío")
    private String estado; // APROBADO, RECHAZADO, PENDIENTE
}