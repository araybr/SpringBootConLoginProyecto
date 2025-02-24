package com.example.springbootloginclase2425.controller;

import com.example.springbootloginclase2425.auth.AuthController;
import com.example.springbootloginclase2425.model.Result;
import com.example.springbootloginclase2425.model.Pedido;
import com.example.springbootloginclase2425.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private Logger logger = Logger.getLogger(AuthController.class.getName());

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        logger.info("Intentando coger todos los pedidos");
        return pedidoService.getAllPedidos();
    }

    @PostMapping
    public Pedido addPedido(@RequestBody Pedido pedido) {
        logger.info("Intentando añadir un pedido");
        return pedidoService.addPedido(pedido);
    }

    @PutMapping
    public Pedido updatePedido(@RequestBody Pedido pedido) {
        logger.info("Intentando modificar un pedido");
        return pedidoService.updatePedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Long id) {
        logger.info("Intentando eliminar un pedido");
        pedidoService.deletePedido(id);
    }
}

