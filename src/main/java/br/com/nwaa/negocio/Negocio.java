package br.com.nwaa.negocio;

import br.com.nwaa.dao.IDados;
import br.com.nwaa.entidades.*;
import br.com.nwaa.excecao.CompraNaoFinalizada;
import br.com.nwaa.util.Util;

import java.math.BigDecimal;
import java.util.List;

public class Negocio {

    private IDados idados;

    private RealizaCalculoImposto realizaCalculoImposto = null;
    private RealizaCalculoDesconto realizaCalculoDesconto = null;
    private RealizaCalculoFrete realizaCalculoFrete = null;

    public Negocio(IDados idados) {
        this.idados = idados;
    }

    public Cliente pesquisarCliente(String cpf) {
        if (cpf.equals("")) {
            return null;
        } else {
            return idados.pesquisarCliente(cpf);
        }
    }

    public List<Produto> listarProdutos() {
        return idados.listarProdutos();
    }

    public Produto pesquisarProduto(String codigo) {
        if (codigo.equals("")) {
            return null;
        } else {
            return idados.pesquisarProduto(codigo);
        }
    }

    public Compra iniciarCompra() {
        return idados.iniciarCompra();
    }

    public void adicionarProdutosCompra(List<Produto> produtos) {
        idados.adicionarProdutosCompra(produtos);
    }

    public void selecionarProduto(Produto produto) {
        idados.selecionarProduto(produto);
    }

    public void iniciarSelecaoProduto() {
        idados.iniciarSelecaoProduto();
    }

    public List<Produto> listarProdutosSelecionados() {
        return idados.listarProdutosSelecionados();
    }

    public Frete realizarCalculoFrete(Entrega entrega, List<Produto> produtos){
        realizaCalculoFrete = new RealizaCalculoFrete(entrega, produtos);
        Frete frete = new Frete();
        frete.setValor(realizaCalculoFrete.calcular());
        return frete;
    }

    public double realizarCalculoDesconto(Cliente cliente, List<Produto> produtos){
        realizaCalculoDesconto = new RealizaCalculoDesconto(cliente, produtos);
        return realizaCalculoDesconto.calcular();
    }

    public double realizarCalculoImposto(List<Produto> produtos){
        realizaCalculoImposto = new RealizaCalculoImposto(produtos);
        return realizaCalculoImposto.calcular();
    }

    public double calcularSubtotal(List<Produto> produtos) {
        double valor = 0L;
        for (Produto pro : produtos) {
            valor = valor + pro.getValorUnitario();
        }
        return Util.arredondar(valor);
    }

    public double calcularValorTotal(Compra compra) {
        return Util.arredondar(((compra.getSubTotal() + compra.getValorImposto()) - compra.getValorDesconto()) + compra.getFrete().getValor());
    }

    public String enviarEmailConfirmacaoCompra(Compra compra) throws CompraNaoFinalizada {
        if (compra.isCheckout()){
            compra.getCliente().getEmail().setAssunto("Confirmação de Compra");
            compra.getCliente().getEmail().setMensagem(obterMensagemConfirmacaoCompra(compra));
        }else{
            throw new CompraNaoFinalizada();
        }
        return compra.getCliente().getEmail().getMensagem();
    }

    private String obterMensagemConfirmacaoCompra(Compra compra){
        return "Compra Realizada com Sucesso!" +
                "\nOlá, " + compra.getCliente().getNome() + "!"
                + "\nSua Compra está confirmada!";
    }

}
