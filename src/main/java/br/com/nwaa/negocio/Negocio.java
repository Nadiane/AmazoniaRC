package br.com.nwaa.negocio;

import br.com.nwaa.dao.IDados;
import br.com.nwaa.entidades.*;
import br.com.nwaa.util.Util;

import java.math.BigDecimal;
import java.util.List;

public class Negocio {

    private IDados idados;

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

    public String obterMensagemConfirmacaoCompra(Compra compra){
        return "Compra Realizada com Sucesso!" +
                "Olá, " + compra.getCliente().getNome() + "!"
                + "\nSua Compra está confirmada!";
    }

}
