package com.duoc.logihub.auth.controller;

import com.duoc.logihub.auth.model.Usuario;
import com.duoc.logihub.auth.service.AuthService;
import jakarta.validation.Valid; // Necesario para Bean Validation 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) { 
        this.service = service; 
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@Valid @RequestBody Usuario u) { // @Valid activa el Punto 1 
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(u));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario u) {
        String token = service.validarAcceso(u.getUsername(), u.getPassword());
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
    }
}