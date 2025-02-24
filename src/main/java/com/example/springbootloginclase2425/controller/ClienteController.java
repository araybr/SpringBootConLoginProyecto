package com.example.springbootloginclase2425.controller;


import com.example.springbootloginclase2425.auth.AuthController;
import com.example.springbootloginclase2425.model.Cliente;
import com.example.springbootloginclase2425.model.Result;
import com.example.springbootloginclase2425.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Cliente", description = "Endpoints de Cliente")
public class ClienteController {

    private Logger logger = Logger.getLogger(AuthController.class.getName());

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Coger todos los clientes", description = "Este endpoint coge todos los clientes.")
    public List<Cliente> getAllClientes() {
        logger.info("Intentando coger todos los clientes");
        return clienteService.getAllClientes();
    }

    @PostMapping
    @Operation(summary = "Añadir un cliente", description = "Este endpoint añade un cliente pasando 'RequestBody' como parametro.")
    public Cliente addCliente(@RequestBody Cliente cliente) {
        logger.info("Intentando añadir un cliente");
        return clienteService.addCliente(cliente);
    }

    @PutMapping
    @Operation(summary = "Modificar un cliente", description = "Este endpoint modifica un cliente pasando 'RequestBody' como parametro.")
    public Cliente updateCliente(@RequestBody Cliente cliente) {
        logger.info("Intentando modificar un cliente");
        return clienteService.updateCliente(cliente);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un cliente", description = "Este endpoint elimina un cliente a traves de una id que se pasa como parametro.")
    public void deleteCliente(@PathVariable Long id) {
        logger.info("Intentando eliminar un cliente");
        clienteService.deleteCliente(id);
    }
}
