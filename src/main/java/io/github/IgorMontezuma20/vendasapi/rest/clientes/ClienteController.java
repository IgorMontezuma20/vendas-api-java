package io.github.IgorMontezuma20.vendasapi.rest.clientes;

import io.github.IgorMontezuma20.vendasapi.model.Cliente;
import io.github.IgorMontezuma20.vendasapi.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public ResponseEntity salvar(@RequestBody ClienteFormRequest request){
       Cliente cliente = request.toModel();
       repository.save(cliente);
       return ResponseEntity.ok(ClienteFormRequest.fromModel(cliente));
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> atualizar(
            @PathVariable Long id,
            @RequestBody ClienteFormRequest request
    ){
        Optional<Cliente> clienteExistente = repository.findById(id);

        if(clienteExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Cliente cliente = request.toModel();
        cliente.setId(id);
        repository.save(cliente);
        return ResponseEntity.noContent().build();
    }
}
