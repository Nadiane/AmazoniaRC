package br.com.nwaa.dao;

import br.com.nwaa.entidades.Cliente;
import br.com.nwaa.entidades.Compra;
import br.com.nwaa.entidades.Produto;

import java.util.List;

public interface IDados {

    public Cliente pesquisarCliente(String cpf);
    public List<Produto> listarProdutos();
    public Produto pesquisarProduto(String codigo);
    public void adicionarProdutoCompra(Produto produto);
    public void inserirCompra(Compra compra);
    public Compra iniciarCompra();
}
