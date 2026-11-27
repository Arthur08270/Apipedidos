package com.example.apipedidos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.apipedidos.models.Clientes;
import com.example.apipedidos.repository.ClientesRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientesService {

    private final ClientesRepository clientesRepository;

    public Clientes criarCliente(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    public List<Clientes> listarClientes() {
        return clientesRepository.findAll();
    }

    public Clientes buscarClientePorId(Long id) {
        return clientesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com id: " + id));
    }

    public Clientes atualizarCliente(Clientes clientesAtualizado, Long id) {
        Clientes clienteExistente = buscarClientePorId(id);
        clientesAtualizado.setId(clienteExistente.getId());
        return clientesRepository.save(clientesAtualizado);
    }

    public void deletarCliente(Long id) {
        Clientes clienteExistente = buscarClientePorId(id);
        clientesRepository.delete(clienteExistente);
    }
}