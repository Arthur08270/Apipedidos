package com.example.apipedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apipedidos.models.Clientes;

@Repository 
public interface ClientesRepository extends JpaRepository<Clientes, Long>{

}
