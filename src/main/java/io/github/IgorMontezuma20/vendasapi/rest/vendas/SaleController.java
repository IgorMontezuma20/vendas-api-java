package io.github.IgorMontezuma20.vendasapi.rest.vendas;

import io.github.IgorMontezuma20.vendasapi.model.Sale;
import io.github.IgorMontezuma20.vendasapi.model.repository.SaleItemRepository;
import io.github.IgorMontezuma20.vendasapi.model.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin("*")
public class SaleController {


    @Autowired
    private SaleRepository repository;

    @Autowired
    private SaleItemRepository saleItemRepository;

    @PostMapping
    @Transactional
    public void createSale(@RequestBody Sale sale){
        repository.save(sale);
        sale.getItens().stream().forEach(iv -> iv.setVenda(sale));
        saleItemRepository.saveAll(sale.getItens());
    }
}
