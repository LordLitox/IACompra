package com.duoc.logihub.reviews.service;

import com.duoc.logihub.reviews.model.Resena;
import com.duoc.logihub.reviews.repository.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {

    private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);
    private final ReviewRepository repo;

    public ReviewService(ReviewRepository repo) {
        this.repo = repo;
    }

    public Resena publicarResena(Resena resena) {
        logger.info("Publicando reseña para producto ID: {} por usuario ID: {}", 
                    resena.getProductoId(), resena.getUsuarioId());
        return repo.save(resena);
    }

    public List<Resena> obtenerPorProducto(Long productoId) {
        logger.info("Consultando reseñas del producto ID: {}", productoId);
        return repo.findByProductoId(productoId);
    }
}