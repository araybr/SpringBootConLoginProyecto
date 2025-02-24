package com.example.springbootloginclase2425.controller;

import com.example.springbootloginclase2425.auth.AuthController;
import com.example.springbootloginclase2425.model.Result;
import com.example.springbootloginclase2425.model.Pedido;
import com.example.springbootloginclase2425.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/pedidos")
@Tag(name = "Pedido", description = "Endpoints de Pedido")
public class PedidoController {

    private Logger logger = Logger.getLogger(AuthController.class.getName());

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    @Operation(summary = "Coger todos los pedidos", description = "Este endpoint coge todos los pedidos.")
    public List<Pedido> getAllPedidos() {
        logger.info("Intentando coger todos los pedidos");
        return pedidoService.getAllPedidos();
    }

    @PostMapping
    @Operation(summary = "Añadir un pedido", description = "Este endpoint añade un pedido pasando 'RequestBody' como parametro.")
    public Pedido addPedido(@RequestBody Pedido pedido) {
        logger.info("Intentando añadir un pedido");
        return pedidoService.addPedido(pedido);
    }

    @PutMapping
    @Operation(summary = "Modificar un pedido", description = "Este endpoint modifica un pedido pasando 'RequestBody' como parametro.")
    public Pedido updatePedido(@RequestBody Pedido pedido) {
        logger.info("Intentando modificar un pedido");
        return pedidoService.updatePedido(pedido);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un pedido", description = "Este endpoint elimina un pedido a traves de una id que se pasa como parametro.")
    public void deletePedido(@PathVariable Long id) {
        logger.info("Intentando eliminar un pedido");
        pedidoService.deletePedido(id);
    }
}

