package com.example.springbootloginclase2425.repository;

import com.example.springbootloginclase2425.model.Pedido;
import com.example.springbootloginclase2425.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findAllByCliente(Cliente cliente);
}
