package com.example.apipedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apipedidos.models.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Long>{

    
} 
