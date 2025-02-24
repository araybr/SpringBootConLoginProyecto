package com.example.springbootloginclase2425.controller;


import com.example.springbootloginclase2425.auth.AuthController;
import com.example.springbootloginclase2425.model.Cliente;
import com.example.springbootloginclase2425.model.Result;
import com.example.springbootloginclase2425.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private Logger logger = Logger.getLogger(AuthController.class.getName());

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAllClientes() {
        logger.info("Intentando coger todos los clientes");
        return clienteService.getAllClientes();
    }

    @PostMapping
    public Cliente addCliente(@RequestBody Cliente cliente) {
        logger.info("Intentando añadir un cliente");
        return clienteService.addCliente(cliente);
    }

    @PutMapping
    public Cliente updateCliente(@RequestBody Cliente cliente) {
        logger.info("Intentando modificar un cliente");
        return clienteService.updateCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        logger.info("Intentando eliminar un cliente");
        clienteService.deleteCliente(id);
    }
}
