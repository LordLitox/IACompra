package com.duoc.logihub.catalog.service;

import com.duoc.logihub.catalog.model.Producto;
import com.duoc.logihub.catalog.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    private static final Logger logger = LoggerFactory.getLogger(ProductoService.class);
    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listarTodos() {
        logger.info("Consultando todos los productos del catálogo");
        return repo.findAll();
    }

    public Producto guardar(Producto p) {
        logger.info("Guardando nuevo producto: {}", p.getNombre());
        return repo.save(p);
    }

    public List<Producto> filtrarPorCategoria(String cat) {
        logger.info("Filtrando productos por categoría: {}", cat);
        return repo.findByCategoriaIgnoreCase(cat);
    }
}