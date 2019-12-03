package br.com.nwaa.dao;

import br.com.nwaa.entidades.Cliente;
import br.com.nwaa.entidades.Compra;
import br.com.nwaa.entidades.Produto;

import java.util.List;

public interface IDados {

   Cliente pesquisarCliente(String cpf);
   List<Produto> listarProdutos();
   Produto pesquisarProduto(String codigo);
   Compra iniciarCompra();
   void adicionarProdutosCompra(List<Produto> produtos);
   void inserirCompra(Compra compra);
   void selecionarProduto(Produto produto);
   void iniciarSelecaoProduto();
   List<Produto> listarProdutosSelecionados();

}
