package com.example.apipedidos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.apipedidos.models.Clientes;
import com.example.apipedidos.service.ClientesService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController 
@RequestMapping("/api/clientes")
@AllArgsConstructor 
public class ClientesController {
    
    private final ClientesService clientesService;


    @PostMapping 
    public ResponseEntity<Clientes> criarCliente(@RequestBody @Valid Clientes clientes){
        Clientes novoCliente = clientesService.criarCliente();
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
    }

    @GetMapping 
    public ResponseEntity<List<Clientes>> listarClientes(){
        return ResponseEntity.ok(clientesService.listarClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> buscarClientePorId(@PathVariable Long id){
        return ResponseEntity.ok(clientesService.buscarClientePorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> atualizarCliente(@RequestBody @Valid Clientes clientes, @PathVariable Long id){
        Clientes clienteAtualizado = clientesService.atualizarCliente(clientes, id);
        return ResponseEntity.ok().body(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clientesService.deletarCliente(id);
        return ResponseEntity.ok().build();
    }

}
