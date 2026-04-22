package com.duoc.logihub.inventory.service;

import com.duoc.logihub.inventory.model.Inventario;
import com.duoc.logihub.inventory.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);
    private final InventoryRepository repo;

    public InventoryService(InventoryRepository repo) {
        this.repo = repo;
    }

    public Inventario actualizarStock(Long productoId, int nuevaCantidad) {
        logger.info("Actualizando stock para producto ID: {} a {} unidades", productoId, nuevaCantidad);
        Inventario inv = repo.findByProductoId(productoId).orElse(new Inventario());
        inv.setProductoId(productoId);
        inv.setCantidad(nuevaCantidad);
        return repo.save(inv);
    }

    public int obtenerStock(Long productoId) {
        logger.info("Consultando stock disponible para producto ID: {}", productoId);
        return repo.findByProductoId(productoId)
                   .map(Inventario::getCantidad)
                   .orElse(0);
    }
}