package br.com.nwaa.entidades;

import java.util.List;

public class Compra {

    private Cliente cliente;
    private List<Produto> produtos;
    private Frete frete;
    private double valorTotal;
    private double valorDesconto;
    private boolean checkout;

    public Compra() {
    }

    public Compra(Cliente cliente, List<Produto> produtos, Frete frete, double valorTotal, double valorDesconto, boolean checkout) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.frete = frete;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.checkout = checkout;
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

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

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
