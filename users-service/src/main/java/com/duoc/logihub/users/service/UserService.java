package com.duoc.logihub.users.service;

import com.duoc.logihub.users.model.UsuarioPerfil;
import com.duoc.logihub.users.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class); // [cite: 287]
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public UsuarioPerfil crearPerfil(UsuarioPerfil perfil) {
        logger.info("Creando perfil para el email: {}", perfil.getEmail()); // [cite: 90]
        return repo.save(perfil);
    }

    public UsuarioPerfil obtenerPorAuthId(Long authId) {
        logger.info("Buscando perfil asociado al authId: {}", authId);
        return repo.findByAuthId(authId).orElse(null);
    }

    public List<UsuarioPerfil> listarTodos() {
        return repo.findAll();
    }
}