package br.com.nwaa.repositorio;

import br.com.nwaa.entidades.*;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDadosMemoria {

    private static RepositorioDadosMemoria repositorio;

    private List<Cliente> clientes;
    private List<Produto> produtos;
    private List<Produto> produtosSelecionados;
    private Compra compra;

    private RepositorioDadosMemoria() {
        carregarClientes();
        carregarProdutos();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void setProdutosSelecionados(List<Produto> produtosSelecionados) {
        this.produtosSelecionados = produtosSelecionados;
    }

    public List<Produto> getProdutosSelecionados() {
        return produtosSelecionados;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public static RepositorioDadosMemoria getInstance(){
        if (repositorio == null){
           repositorio = new RepositorioDadosMemoria();
        }
        return repositorio;
    }

    private void carregarClientes(){
        Cliente cliente1 = new Cliente(
                "01234567890",
                "Sebastiana Carvalho",
                new Endereco(
                        "Rua Agostinho",
                        101,
                        "Dois Carneiros",
                        "Jaboatão",
                        "54280175"
                ),
                new Email(
                        "",
                        "nad.gat@gmail.com",
                        "",
                        ""
                ),
                new CupomDesconto(
                        "10DESC",
                        10
                )
        );

        Cliente cliente2 = new Cliente(
                "09876543211",
                "Roberto Carlos",
                new Endereco(
                        "Rua Francisco",
                        109,
                        "Dois Carneiros",
                        "Jaboatão",
                        "54280690"
                ),
                new Email(
                        "",
                        "email@amazoniaRD.com.br",
                        "",
                        ""
                ),
                null
        );
        clientes = new ArrayList<Cliente>();
        clientes.add(cliente1);
        clientes.add(cliente2);
    }

    private void carregarProdutos(){
        Produto produto1 = new Produto(
                "P0001",
                "DVD - Game Of Thrones",
                "A Oitava Temporada Completa - 4 Discos",
                129.90,
                0,
                1,
                0.100,
                false,
                false,
                false
        );

        Produto produto2 = new Produto(
                "P0002",
                "Revista Oficial do PlayStation",
                "Edição 179",
                5.99,
                0,
                1,
                0.100,
                false,
                true,
                true
        );

        Produto produto3 = new Produto(
                "P0003",
                "Taylor Swift - Lover",
                "CD Standard Edition",
                47.90,
                0,
                1,
                0.100,
                false,
                true,
                false
        );

        Produto produto4 = new Produto(
                "P0004",
                "Heróis da Fé",
                "EBook Kindle",
                13.00,
                0,
                1,
                0.100,
                true,
                true,
                true
        );

        produtos = new ArrayList<Produto>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);
    }

    public Compra iniciarCompra() {
        return compra = new Compra();
    }

    public void adicionarProdutoCompra(Produto produto){
        compra.setProdutos(new ArrayList<Produto>());
        compra.getProdutos().add(produto);
    }

    public void selecionarProduto(Produto produto){
        produtosSelecionados.add(produto);
    }

    public void iniciarSelecaoProduto(){
        produtosSelecionados = new ArrayList<Produto>();
    }

    public List<Produto> listarProdutosSelecionados(){
        return produtosSelecionados;
    }

}
