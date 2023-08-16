package io.github.IgorMontezuma20.vendasapi.rest.dashboard;

import io.github.IgorMontezuma20.vendasapi.model.repository.projections.VendaPorMes;

import java.util.List;

public class DashBoardData {

    private Long produtos;
    private Long clientes;
    private Long vendas;
    private List<VendaPorMes> vendasPorMes ;

    public DashBoardData(Long produtos, Long clientes, Long vendas, List<VendaPorMes> vendasPorMes) {
        this.produtos = produtos;
        this.clientes = clientes;
        this.vendas = vendas;
        this.vendasPorMes = vendasPorMes;
    }

    public Long getProdutos() {
        return produtos;
    }

    public void setProdutos(Long produtos) {
        this.produtos = produtos;
    }

    public Long getClientes() {
        return clientes;
    }

    public void setClientes(Long clientes) {
        this.clientes = clientes;
    }

    public Long getVendas() {
        return vendas;
    }

    public void setVendas(Long vendas) {
        this.vendas = vendas;
    }

    public List<VendaPorMes> getVendasPorMes() {
        return vendasPorMes;
    }

    public void setVendasPorMes(List<VendaPorMes> vendasPorMes) {
        this.vendasPorMes = vendasPorMes;
    }
}
