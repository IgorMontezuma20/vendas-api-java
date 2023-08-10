package io.github.IgorMontezuma20.vendasapi.rest.vendas;

import io.github.IgorMontezuma20.vendasapi.model.Sale;
import io.github.IgorMontezuma20.vendasapi.model.repository.SaleRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin("*")
public class SaleController {


    private SaleRepository repository;

    @PostMapping
    public void makeSale(@RequestBody Sale sale){

    }
}
