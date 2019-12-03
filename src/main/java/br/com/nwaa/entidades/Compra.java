package br.com.nwaa.entidades;

import java.util.List;

public class Compra {

    private int codigo;
    private Cliente cliente;
    private List<Produto> produtos;
    private Frete frete;
    private Entrega entrega;
    private double valorTotal;
    private double valorDesconto;
    private boolean checkout;

    public Compra() {
    }

    public Compra(int codigo, Cliente cliente, List<Produto> produtos, Frete frete, Entrega entrega, double valorTotal, double valorDesconto, boolean checkout) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.frete = frete;
        this.entrega = entrega;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.checkout = checkout;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) { this.frete = frete; }

    public void setEntrega(Entrega entrega) { this.entrega = entrega; }

    public Entrega getEntrega() { return entrega; }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }
}
