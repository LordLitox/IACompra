package com.duoc.logihub.users.controller;

import com.duoc.logihub.users.model.UsuarioPerfil;
import com.duoc.logihub.users.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioPerfil> crear(@Valid @RequestBody UsuarioPerfil perfil) { 
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearPerfil(perfil)); 
    }

    @GetMapping("/auth/{authId}")
    public ResponseEntity<UsuarioPerfil> getByAuth(@PathVariable Long authId) {
        UsuarioPerfil p = service.obtenerPorAuthId(authId);
        return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build(); 
    }

    @GetMapping
    public ResponseEntity<List<UsuarioPerfil>> getAll() {
        return ResponseEntity.ok(service.listarTodos());
    }
}