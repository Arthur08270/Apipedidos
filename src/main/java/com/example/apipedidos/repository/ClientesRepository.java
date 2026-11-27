package com.example.apipedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apipedidos.models.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, Long>{

}
