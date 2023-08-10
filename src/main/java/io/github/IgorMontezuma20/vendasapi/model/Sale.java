package io.github.IgorMontezuma20.vendasapi.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "venda")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento")
    private PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "venda")
    private List<SaleItem> itens;

    @Column
    private BigDecimal total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<SaleItem> getItens() {
        return itens;
    }

    public void setItens(List<SaleItem> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", paymentMethod=" + paymentMethod +
                ", itens=" + itens +
                ", total=" + total +
                '}';
    }
}
