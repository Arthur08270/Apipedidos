package com.example.apipedidos.service;

import java.util.List;

import com.example.apipedidos.models.Pedidos;
import com.example.apipedidos.repository.PedidosRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor 
public class PedidosService {
    
    private final PedidosRepository pedidosRepository;


    public Pedidos criarPedidos(Pedidos pedidos){
        return pedidosRepository.save(pedidos);
    }

    public List<Pedidos> listarPedidos(){
        return pedidosRepository.findAll();
    }

    public Pedidos buscarPedidosPorId(Long id){
        return pedidosRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
    }

    public Pedidos atualizarPedidos(Pedidos pedidos, Long id){
        Pedidos pedidosAtualizado = buscarPedidosPorId(id);

        pedidosAtualizado.setNomeProduto(pedidos.getNomeProduto());
        pedidosAtualizado.setIdentificador(pedidos.getIdentificador());
        pedidosAtualizado.setQuantidade(pedidos.getQuantidade());
        pedidosAtualizado.setValorProduto(pedidos.getValorProduto());
        
        return pedidosRepository.save(pedidosAtualizado);
    }

    public void deletarPedidos(Long id){
        Pedidos pedidos = buscarPedidosPorId(id);
        pedidosRepository.delete(pedidos);
    }

}
