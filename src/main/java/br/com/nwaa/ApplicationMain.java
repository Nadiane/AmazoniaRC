package br.com.nwaa;

import br.com.nwaa.entidades.*;
import br.com.nwaa.fachada.ComprasAmazoniaFachada;
import br.com.nwaa.negocio.RealizaCalculoDesconto;
import br.com.nwaa.negocio.RealizaCalculoFrete;
import br.com.nwaa.negocio.RealizaCalculoImpostoImpl;
import br.com.nwaa.util.Util;
import sun.java2d.loops.GeneralRenderer;

import java.util.ArrayList;
import java.util.List;

public class ApplicationMain {

    public static void main(String[] args) {

        System.out.println("Compras Amazonia RC");

        System.out.println("Carregando Cliente...");

        Cliente cliente = ComprasAmazoniaFachada.getInstance().pesquisarCliente("01234567890");

        System.out.println("CPF: " + cliente.getCpf() + "\nNome: " + cliente.getNome());

        System.out.println("Endeço: " + cliente.getEndereco().getLogradouro() + ", " +
                cliente.getEndereco().getNumero() + ", " +
                cliente.getEndereco().getBairro() + " - " +
                cliente.getEndereco().getCidade() + " - " +
                cliente.getEndereco().getCep());

        System.out.println("\nCarrinho de Compras");

        System.out.println("Adicionando Itens Ao Carrinho");

        List<Produto> produtos = new ArrayList<Produto>();

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

        //Cálculo do Imposto Aqui
        RealizaCalculoImpostoImpl calculoImposto = new RealizaCalculoImpostoImpl();
        produto1.setValorImposto(Util.arredondar(calculoImposto.calcularImposto(produto1)));
        produto2.setValorImposto(Util.arredondar(calculoImposto.calcularImposto(produto2)));
        produto3.setValorImposto(Util.arredondar(calculoImposto.calcularImposto(produto3)));
        produto4.setValorImposto(Util.arredondar(calculoImposto.calcularImposto(produto4)));

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);

        for (Produto pro:produtos) {
            System.out.println("\nNome: " + pro.getNome() +
                    "\nDescrição: " + pro.getDescricao() +
                    "\nValor Unitário: " + pro.getValorUnitario() +
                    "\nValor Imposto: " + pro.getValorImposto() +
                    "\nQuantidade: " + pro.getQuantidade() +
                    "\nPeso; " + pro.getPeso() +
                    "\nMídia Digital: " +  pro.isMidiaDigital() +
                    "\nEm Promoção: " + pro.isEmPromocao() +
                    "\nIsento de Imposto: " + pro.isIsentoImposto());
        }

        System.out.println("\nAdicionando Local de Entrega...");
        Entrega entrega = new Entrega();
        entrega.setCepOrigem("51021520");
        entrega.setCepDestino("54280175");

        for (Produto pro:produtos) {
            entrega.setPeso(entrega.getPeso() + pro.getPeso());
        }

        System.out.println("CEP Origem: " + entrega.getCepOrigem() + "\nCEP Destino: " + entrega.getCepDestino() + "\nPeso Total: " + entrega.getPeso());

        System.out.println("\nProcessando a Compra...");

        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setProdutos(produtos);

        //Calcular Desconto da Compra
        RealizaCalculoDesconto calculoDesconto = new RealizaCalculoDesconto();
        compra.setValorDesconto(calculoDesconto.calcular(cliente, produtos));
        System.out.println("\nValor de Desconto: " + compra.getValorDesconto());

        //Calcular Frete
        RealizaCalculoFrete realizaCalculoFrete = new RealizaCalculoFrete();
        compra.setFrete(realizaCalculoFrete.calcular(entrega, produtos));
        System.out.println("Valor do Frete: " + compra.getFrete().getValor());

        //Finalizar Compra
        for (Produto pro:produtos) {
            compra.setValorTotal(compra.getValorTotal() + pro.getValorUnitario());
        }
        System.out.println("Valor Total da Compra: " + compra.getValorTotal());

        compra.setCheckout(true);

        System.out.println("Compra Finalizada com Sucesso!");

        //Email de Confirmação de Compra

    }
}