package io.github.IgorMontezuma20.vendasapi.rest.vendas;

import io.github.IgorMontezuma20.vendasapi.model.Venda;
import io.github.IgorMontezuma20.vendasapi.model.repository.ItemVendaRepository;
import io.github.IgorMontezuma20.vendasapi.model.repository.VendaRepository;
import io.github.IgorMontezuma20.vendasapi.service.RelatorioVendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin("*")
public class VendasController {

    @Autowired
    private VendaRepository repository;
    @Autowired
    private ItemVendaRepository itemVendaRepository;
    @Autowired
    private RelatorioVendasService relatorioVendasService;

    @PostMapping
    @Transactional
    public void realizarVenda( @RequestBody Venda venda) {
        repository.save(venda);
        venda.getItens().stream().forEach( iv -> iv.setVenda(venda));
        itemVendaRepository.saveAll(venda.getItens());
    }

    @GetMapping
    public ResponseEntity<byte[]> relatorioVendas(){
       byte[] relatorioGerado = relatorioVendasService.gerarRelatorio();
        return ResponseEntity.ok(null);
    }
}
