package br.com.nwaa;

import br.com.nwaa.entidades.Cliente;
import br.com.nwaa.entidades.Compra;
import br.com.nwaa.entidades.Entrega;
import br.com.nwaa.entidades.Produto;
import br.com.nwaa.fachada.ComprasAmazoniaFachada;
import br.com.nwaa.util.Util;

import java.util.List;

public class ApplicationMain {

    public static void main(String[] args) {

        System.out.println("<----- Compras Amazonia RC ----->");

        System.out.println("\n<----- Carregando Cliente... ----->");

        Cliente cliente = ComprasAmazoniaFachada.getInstance().pesquisarCliente("01234567890");

        System.out.println(cliente.toString());

        System.out.println("\n<----- Listando Produtos... ----->");

        List<Produto> produtos = ComprasAmazoniaFachada.getInstance().listarProdutos();

        for (Produto pro : produtos) {
            System.out.println(pro);
        }

        System.out.println("\n<----- Adicionando Itens à Compra ----->");

        ComprasAmazoniaFachada.getInstance().iniciarSelecaoProduto();

        System.out.println("\n<----- Itens Selecionados: ----->");

        Produto pro1 = ComprasAmazoniaFachada.getInstance().pesquisarProduto("P0001");
        Produto pro2 = ComprasAmazoniaFachada.getInstance().pesquisarProduto("P0003");

        ComprasAmazoniaFachada.getInstance().selecionarProduto(pro1);
        ComprasAmazoniaFachada.getInstance().selecionarProduto(pro2);

        List<Produto> produtosSelecionados = ComprasAmazoniaFachada.getInstance().listarProdutosSelecionados();

        //Calculando Imposto
        double totalImposto = Util.arredondar(ComprasAmazoniaFachada.getInstance().realizarCalculoImposto(produtosSelecionados));

        for (Produto pro:produtosSelecionados) {
            System.out.println(pro);
        }

        System.out.println("\n<----- Comprar ----->");

        ComprasAmazoniaFachada.getInstance().iniciarCompra();
        ComprasAmazoniaFachada.getInstance().adicionarProdutosCompra(produtosSelecionados);


        System.out.println("\n<----- Adicionando Local de Entrega... ----->");
        Entrega entrega = new Entrega();
        entrega.setCepOrigem("51021520");
        entrega.setCepDestino("54280175");

        for (Produto pro : produtosSelecionados) {
            entrega.setPeso(entrega.getPeso() + pro.getPeso());
        }

        System.out.println(entrega);

        System.out.println("\n<----- Processando a Compra... ----->");

        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setProdutos(produtos);

        //Calcular SubTotal
        compra.setSubTotal(ComprasAmazoniaFachada.getInstance().calcularSubtotal(produtos));
        System.out.println("SubTotal: " + compra.getSubTotal());

        //Cálculo do Imposto Aqui
        compra.setValorImposto(totalImposto);
        System.out.println("Valor Imposto: " + compra.getValorImposto());

        //Calcular Desconto da Compra
        compra.setValorDesconto(ComprasAmazoniaFachada.getInstance().realizarCalculoDesconto(cliente, produtos));
        System.out.println("Valor de Desconto: " + compra.getValorDesconto());

        //Calcular Frete
        compra.setFrete(ComprasAmazoniaFachada.getInstance().realizarCalculoFrete(entrega, produtosSelecionados));
        System.out.println("Valor do Frete: " + compra.getFrete().getValor());

        //Finalizar Compra
        compra.setValorTotal(ComprasAmazoniaFachada.getInstance().calcularValorTotal(compra));

        System.out.println("Valor Total da Compra: " + compra.getValorTotal());

        compra.setCheckout(true);

        System.out.println("\n<----- Compra Finalizada com Sucesso! ----->");

        //Email de Confirmação de Compra

    }
}