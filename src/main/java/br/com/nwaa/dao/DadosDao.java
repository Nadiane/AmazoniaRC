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
        return null;
    }

    @Override
    public Produto pesquisarProduto(String codigo) {
        return null;
    }

    @Override
    public void adicionarProdutoCompra(Produto produto) {

    }

    @Override
    public void inserirCompra(Compra compra) {

    }

    @Override
    public Compra iniciarCompra() {
        return null;
    }
}
