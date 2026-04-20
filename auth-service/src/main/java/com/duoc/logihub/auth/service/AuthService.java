package com.duoc.logihub.auth.service;

import com.duoc.logihub.auth.model.Usuario;
import com.duoc.logihub.auth.repository.UsuarioRepository;
import org.slf4j.Logger; // Punto 2: SLF4J [cite: 90, 287]
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {

    // Punto 2: Definición del Logger [cite: 90, 287]
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final UsuarioRepository repo;

    public AuthService(UsuarioRepository repo) { 
        this.repo = repo; 
    }

    public String validarAcceso(String user, String pass) {
        logger.info("Iniciando proceso de autenticación para el usuario: {}", user); // Log de info [cite: 90]
        
        Optional<Usuario> oUser = repo.findByUsername(user);
        
        if (oUser.isPresent() && oUser.get().getPassword().equals(pass)) {
            logger.info("Autenticación exitosa para el usuario: {}", user);
            return "Token-Simulado-" + user;
        }
        
        logger.warn("Fallo de autenticación: Credenciales inválidas para el usuario: {}", user); // Log de advertencia [cite: 90]
        return null;
    }
    
    public Usuario registrar(Usuario u) {
        logger.info("Registrando nuevo usuario en el sistema: {}", u.getUsername());
        Usuario guardado = repo.save(u);
        logger.info("Usuario guardado exitosamente con ID: {}", guardado.getId());
        return guardado;
    }
}