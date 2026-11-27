import java.util.List;

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

import com.example.apipedidos.service.PedidosService;
import com.example.apipedidos.models.*;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController 
@RequestMapping("/api/pedidos")
@NoArgsConstructor 
public class PedidosController {
    
    private final PedidosService pedidosService;

    @PostMapping 
    public ResponseEntity<Pedidos> criarPedido(@RequestBody @Valid Pedidos pedidos){
        Pedidos novoPedido = pedidosService.criarPedido();
        return ResponseEntity.status(HttpStatusCode.CREATED).body(novoPedido);
    }

    @GetMapping 
    public ResponseEntity<List<Pedidos>> listarPedidos(){
        return ResponseEntity.ok(pedidosService.listarPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> buscarPedidoPorId(@PathVariable Long id){
        return ResponseEntity.ok(pedidosService.buscarPedidoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedidos> atualizarPedido(@RequestBody @Valid Pedidos, @PathVariable Long id){
        Pedidos pedidoAtualizado = pedidosService.atualizarPedido(Pedidos, id);
        return ResponseEntity.ok().body(pedidoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Long id){
        pedidosService.deletarPedido(id);
        return ResponseEntity.ok().build();
    }


}
