package com.example.apipedidos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.apipedidos.models.Pedidos;
import com.example.apipedidos.repository.PedidosRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PedidosService {

    private final PedidosRepository pedidosRepository;

    public Pedidos criarPedido(Pedidos pedidos) {
        return pedidosRepository.save(pedidos);
    }

    public List<Pedidos> listarPedidos() {
        return pedidosRepository.findAll();
    }

    public Pedidos buscarPedidoPorId(Long id) {
        return pedidosRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado com id: " + id));
    }

    public Pedidos atualizarPedido(Pedidos pedidosAtualizado, Long id) {
        Pedidos pedidoExistente = buscarPedidoPorId(id);
        pedidosAtualizado.setId(pedidoExistente.getId());
        return pedidosRepository.save(pedidosAtualizado);
    }

    public void deletarPedido(Long id) {
        Pedidos pedidoExistente = buscarPedidoPorId(id);
        pedidosRepository.delete(pedidoExistente);
    }
}