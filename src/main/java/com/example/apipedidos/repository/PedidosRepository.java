package com.example.apipedidos.repository;

import com.example.apipedidos.models.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    Optional<Pedidos> findByIdentificador(String identificador);
}
