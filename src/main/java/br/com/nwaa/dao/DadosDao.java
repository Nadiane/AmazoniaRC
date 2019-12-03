package br.com.nwaa.dao;

import br.com.nwaa.entidades.Cliente;
import br.com.nwaa.entidades.Compra;
import br.com.nwaa.entidades.Produto;
import br.com.nwaa.repositorio.RepositorioDadosMemoria;

import java.util.List;

public class DadosDao implements IDados{

    @Override
    public Cliente pesquisarCliente(String cpf) {
        Cliente clienteRetorno = null;
        for (Cliente cliente:RepositorioDadosMemoria.getInstance().getClientes()) {
            if (cliente.getCpf().equals(cpf)){
                clienteRetorno = cliente;
                break;
            }
        }
        return clienteRetorno;
    }

    @Override
    public List<Produto> listarProdutos() {
        return RepositorioDadosMemoria.getInstance().getProdutos();
    }

    @Override
    public Produto pesquisarProduto(String codigo) {
        Produto produtoRetorno = null;
        for (Produto produto:RepositorioDadosMemoria.getInstance().getProdutos()) {
            if (produto.getCodigo().equals(codigo)){
                produtoRetorno = produto;
                break;
            }
        }
        return produtoRetorno;
    }

    @Override
    public Compra iniciarCompra() {
        return RepositorioDadosMemoria.getInstance().iniciarCompra();
    }

    @Override
    public void adicionarProdutosCompra(List<Produto> produtos) {
        for (Produto pro:produtos) {
            RepositorioDadosMemoria.getInstance().adicionarProdutoCompra(pro);
        }
    }

    @Override
    public void inserirCompra(Compra compra) {

    }

    @Override
    public void selecionarProduto(Produto produto) {
        RepositorioDadosMemoria.getInstance().selecionarProduto(produto);
    }

    @Override
    public void iniciarSelecaoProduto(){
        RepositorioDadosMemoria.getInstance().iniciarSelecaoProduto();
    }

    @Override
    public List<Produto> listarProdutosSelecionados() {
        return RepositorioDadosMemoria.getInstance().getProdutosSelecionados();
    }

}
