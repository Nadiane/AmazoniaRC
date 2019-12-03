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
    private double valorImposto;
    private double subTotal;
    private boolean checkout;

    public Compra() {
    }

    public Compra(int codigo, Cliente cliente, List<Produto> produtos, Frete frete, Entrega entrega, double valorTotal, double valorDesconto, double valorImposto, double subTotal, boolean checkout) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.produtos = produtos;
        this.frete = frete;
        this.entrega = entrega;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.valorImposto = valorImposto;
        this.subTotal = subTotal;
        this.checkout = checkout;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
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

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getValorImposto() {
        return valorImposto;
    }

    public void setValorImposto(double valorImposto) {
        this.valorImposto = valorImposto;
    }

    public boolean isCheckout() {
        return checkout;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }
}
