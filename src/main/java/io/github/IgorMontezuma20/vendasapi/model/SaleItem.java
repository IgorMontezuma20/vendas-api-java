package io.github.IgorMontezuma20.vendasapi.model;

import javax.persistence.*;

@Entity
@Table(name = "item_venda")
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_venda")
    private Sale venda;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @Column
    private Integer quantidade;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getVenda() {
        return venda;
    }

    public void setVenda(Sale sale) {
        this.venda = sale;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                "id=" + id +
                ", sale=" + venda +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
