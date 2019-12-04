package br.com.nwaa.fachada;

import br.com.nwaa.excecao.CompraNaoFinalizada;
import br.com.nwaa.dao.DadosDao;
import br.com.nwaa.dao.IDados;
import br.com.nwaa.entidades.*;
import br.com.nwaa.negocio.Negocio;
import br.com.nwaa.negocio.RealizaCalculoDesconto;
import br.com.nwaa.negocio.RealizaCalculoFrete;
import br.com.nwaa.negocio.RealizaCalculoImposto;
import br.com.nwaa.servico.email.EnviarEmail;

import java.util.List;

public class ComprasAmazoniaFachada {

    private static ComprasAmazoniaFachada fachada;

    private Negocio negocio;
    private EnviarEmail enviarEmail;

    private ComprasAmazoniaFachada() {
        IDados idados = new DadosDao();
        negocio = new Negocio(idados);
    }

    public static ComprasAmazoniaFachada getInstance(){
        if (fachada == null){
            fachada = new ComprasAmazoniaFachada();
        }
        return fachada;
    }

    public Cliente pesquisarCliente(String cpf) {
        return negocio.pesquisarCliente(cpf);
    }

    public List<Produto> listarProdutos(){
        return negocio.listarProdutos();
    }

    public Produto pesquisarProduto(String codigo){
        return negocio.pesquisarProduto(codigo);
    }

    public Compra iniciarCompra(){ return negocio.iniciarCompra(); }

    public void adicionarProdutosCompra(List<Produto> produtos){
        negocio.adicionarProdutosCompra(produtos);
    }

    public void selecionarProduto(Produto produto){
        negocio.selecionarProduto(produto);
    }

    public void iniciarSelecaoProduto(){
        negocio.iniciarSelecaoProduto();
    }

    public List<Produto> listarProdutosSelecionados(){
        return negocio.listarProdutosSelecionados();
    }

    public Frete realizarCalculoFrete(Entrega entrega, List<Produto> produtos){
        return negocio.realizarCalculoFrete(entrega, produtos);
    }

    public double realizarCalculoDesconto(Cliente cliente, List<Produto> produtos){
        return negocio.realizarCalculoDesconto(cliente, produtos);
    }

    public double realizarCalculoImposto(List<Produto> produtos){
       return negocio.realizarCalculoImposto(produtos);
    }

    public double calcularSubtotal(List<Produto> produtos){
        return negocio.calcularSubtotal(produtos);
    }

    public double calcularValorTotal(Compra compra){
        return negocio.calcularValorTotal(compra);
    }

    public String enviarEmailConfirmacaoCompra(Compra compra) throws CompraNaoFinalizada {
       return negocio.enviarEmailConfirmacaoCompra(compra);
    }
}
