package com.duoc.logihub.orders.service;

import com.duoc.logihub.orders.model.Pedido;
import com.duoc.logihub.orders.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public Pedido crearPedido(Pedido pedido) {
        logger.info("Iniciando creación de pedido para cliente ID: {}", pedido.getClienteId());
        // Aquí en el futuro calcularemos el total llamando al catalog-service
        Pedido guardado = repo.save(pedido);
        logger.info("Pedido creado con éxito. ID: {}, Estado: {}", guardado.getId(), guardado.getEstado());
        return guardado;
    }

    public List<Pedido> obtenerPedidosPorCliente(Long clienteId) {
        logger.info("Consultando historial de pedidos del cliente: {}", clienteId);
        return repo.findByClienteId(clienteId);
    }
}