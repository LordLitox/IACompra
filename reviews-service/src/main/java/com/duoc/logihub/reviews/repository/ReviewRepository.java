package com.duoc.logihub.reviews.repository;

import com.duoc.logihub.reviews.model.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Resena, Long> {
    // Para ver todas las reseñas de un producto específico
    List<Resena> findByProductoId(Long productoId);
}