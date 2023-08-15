package io.github.IgorMontezuma20.vendasapi.rest.vendas;

import io.github.IgorMontezuma20.vendasapi.model.Venda;
import io.github.IgorMontezuma20.vendasapi.model.repository.ItemVendaRepository;
import io.github.IgorMontezuma20.vendasapi.model.repository.VendaRepository;
import io.github.IgorMontezuma20.vendasapi.service.RelatorioVendasService;
import io.github.IgorMontezuma20.vendasapi.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


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

    @GetMapping("/relatorio-vendas")
    public ResponseEntity<byte[]> relatorioVendas(
            @RequestParam(value = "id", required = false, defaultValue = "") Long id,
            @RequestParam(value = "inicio", required = false, defaultValue = "") String inicio,
            @RequestParam(value = "fim", required = false, defaultValue = "") String fim
    ){

        Date dataInicio = DateUtils.fromString(inicio);
        Date dataFim = DateUtils.fromString(fim, true);

        if(dataInicio == null){
            dataInicio = DateUtils.DATA_INICIO_PADRAO;
        }

        if(dataFim == null){
           dataFim = DateUtils.hoje(true);
        }


        var relatorioGerado = relatorioVendasService.gerarRelatorio(id, dataInicio, dataFim);
        var headers = new HttpHeaders();
        var fileName = "relatorio-vendas.pdf";
        headers.setContentDispositionFormData("inline; filename=\"" +fileName+ "\"", fileName);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        var responseEntity = new ResponseEntity<>(relatorioGerado, headers, HttpStatus.OK);
        return responseEntity;
    }
}