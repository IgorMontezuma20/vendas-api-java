package io.github.IgorMontezuma20.vendasapi.rest.produtos;

import io.github.IgorMontezuma20.vendasapi.model.Produto;
import io.github.IgorMontezuma20.vendasapi.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<ProdutoFormRequest> getLista(){

        return repository.findAll().stream()
                .map(ProdutoFormRequest::fromModel)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoFormRequest> getById(@PathVariable Long id){
        Optional<Produto> produtoExistente = repository.findById(id);
        if(produtoExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var produto = produtoExistente.map(ProdutoFormRequest::fromModel).get();
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ProdutoFormRequest salvar( @RequestBody ProdutoFormRequest produto ){

        Produto produtoEntity = produto.toModel();
        repository.save(produtoEntity);
        return ProdutoFormRequest.fromModel(produtoEntity);
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody ProdutoFormRequest produto){
        Optional<Produto> produtoExistente = repository.findById(id);

        if (produtoExistente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Produto entidade = produto.toModel();
        entidade.setId(id);
        repository.save(entidade);

        return ResponseEntity.ok().build();
    }
}
