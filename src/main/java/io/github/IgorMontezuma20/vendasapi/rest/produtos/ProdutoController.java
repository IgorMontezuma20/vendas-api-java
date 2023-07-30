package io.github.IgorMontezuma20.vendasapi.rest.produtos;

import io.github.IgorMontezuma20.vendasapi.model.Produto;
import io.github.IgorMontezuma20.vendasapi.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public ProdutoFormRequest salvar( @RequestBody ProdutoFormRequest produto ){

        Produto produtoEntity = new Produto(
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getSku());

        repository.save(produtoEntity);
        System.out.println(produtoEntity);
        return produto;
    }
}
