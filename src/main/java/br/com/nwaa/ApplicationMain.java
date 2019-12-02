package br.com.nwaa;

import br.com.nwaa.entidades.*;

import java.util.ArrayList;
import java.util.List;

public class ApplicationMain {

    public static void main(String[] args) {

        System.out.println("Compras Amazonia RC");

        System.out.println("Carregando Cliente...");

        Cliente cliente = new Cliente(
           "075.881.154-32",
           "Arthur Leandro",
            new Endereco(
                "Rua Uruguai",
                101,
                "Dois Carneiros",
                "Jaboatão",
                "54280-175"
            ),
            new Email(
                "email@amazoniaRD.com.br",
                "arthur@hotmail.com",
                "Bem Vindo!"
            ),
            new CupomDesconto(
                "10DESC",
                10
            )
        );

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
                "DVD - Game Of Thrones",
                "A Oitava Temporada Completa - 4 Discos",
                129.90,
                1,
                0.100,
                false,
                false,
                false
        );

        Produto produto2 = new Produto(
                "Revista Oficial do PlayStation",
                "Edição 179",
                5.99,
                1,
                0.100,
                false,
                true,
                true
        );

        Produto produto3 = new Produto(
                "Taylor Swift - Lover",
                "CD Standard Edition",
                47.90,
                1,
                0.100,
                false,
                true,
                false
        );

        Produto produto4 = new Produto(
                "Heróis da Fé",
                "EBook Kindle",
                13.00,
                1,
                0.100,
                true,
                true,
                true
        );

        //Cálculo do Imposto Aqui

        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);
        produtos.add(produto4);

        for (Produto pro:produtos) {
            System.out.println("\nNome: " + pro.getNome() +
                    "\nDescrição: " + pro.getDescricao() +
                    "\nValor: " + pro.getValor() +
                    "\nQuantidade: " + pro.getQuantidade() +
                    "\nPeso; " + pro.getPeso() +
                    "\nMídia Digital: " +  pro.isMidiaDigital() +
                    "\nEm Promoção: " + pro.isEmPromocao() +
                    "\nIsento de Imposto: " + pro.isIsentoImposto());
        }

        System.out.println("Processando a Compra...");

        //Calcular Desconto da Compra

        //Calcular Frete

        //Finalizar Compra

        //Email de Confirmação de Compra



    }
}