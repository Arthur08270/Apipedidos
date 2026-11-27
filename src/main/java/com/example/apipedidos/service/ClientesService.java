package com.example.apipedidos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.apipedidos.models.Clientes;
import com.example.apipedidos.repository.ClientesRepository;

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
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
	}

	public Clientes atualizarCliente(Clientes clientes, Long id) {
		Clientes clienteAtualizado = buscarClientePorId(id);
		clienteAtualizado.setNome(clientes.getNome());
		clienteAtualizado.setEmail(clientes.getEmail());
		clienteAtualizado.setTelefone(clientes.getTelefone());
		return clientesRepository.save(clienteAtualizado);
	}

	public void deletarCliente(Long id) {
		Clientes cliente = buscarClientePorId(id);
		clientesRepository.delete(cliente);
	}
}
