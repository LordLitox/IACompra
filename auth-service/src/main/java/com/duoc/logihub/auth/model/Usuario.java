package com.duoc.logihub.auth.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de usuario es obligatorio") // Punto 1: Validation 
    @Size(min = 4, max = 20, message = "El usuario debe tener entre 4 y 20 caracteres")
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank(message = "La contraseña no puede estar vacía") // Punto 1: Validation 
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "El rol es requerido (ADMIN, USER, etc.)")
    private String rol;
}