package io.github.IgorMontezuma20.vendasapi.rest.produtos;

import io.github.IgorMontezuma20.vendasapi.model.Produto;
import io.github.IgorMontezuma20.vendasapi.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public ProdutoFormRequest salvar( @RequestBody ProdutoFormRequest produto ){

        Produto produtoEntity = produto.toModel();
        repository.save(produtoEntity);
        return ProdutoFormRequest.fromModel(produtoEntity);
    }
}
