package io.github.IgorMontezuma20.vendasapi.rest.dashboard;

import io.github.IgorMontezuma20.vendasapi.model.repository.ClienteRepository;
import io.github.IgorMontezuma20.vendasapi.model.repository.ProdutoRepository;
import io.github.IgorMontezuma20.vendasapi.model.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/dashboard")
public class DashBoardController {

    @Autowired
    private VendaRepository vendas;
    @Autowired
    private ClienteRepository clientes;
    @Autowired
    private ProdutoRepository produtos;

    @GetMapping
    public DashBoardData getDashboard(){

        long vendasCount = vendas.count();
        long clientesCount = clientes.count();
        long produtosCount = produtos.count();

        int anoCorrente = LocalDate.now().getYear();
        var vendasPorMes = vendas.obterSomatoriaVendasPorMes(anoCorrente);


        return new DashBoardData(produtosCount, clientesCount, vendasCount, vendasPorMes);
    }
}
