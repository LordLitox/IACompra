package com.duoc.logihub.inventory.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "inventarios")
@Data
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del producto es obligatorio")
    private Long productoId; // Vincula con catalog-service [cite: 186]

    @Min(value = 0, message = "El stock no puede ser negativo")
    private int cantidad;

    @NotBlank(message = "La ubicación de la bodega es obligatoria")
    private String bodega;
}