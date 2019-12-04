package br.com.nwaa;

import br.com.nwaa.entidades.Cliente;
import br.com.nwaa.entidades.Produto;
import br.com.nwaa.fachada.ComprasAmazoniaFachada;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComprasAmazoniaTest {

    @Test
    public void pesquisarClienteTest() {
        Cliente cliente = ComprasAmazoniaFachada.getInstance().pesquisarCliente("01234567890");
        Assert.assertEquals("01234567890", cliente.getCpf());
    }

    @Test
    public void pesquisarClienteNaoExistenteTest() {
        Cliente cliente = ComprasAmazoniaFachada.getInstance().pesquisarCliente("32145609871");
        Assert.assertNull(cliente);
    }

    @Test
    public void pesquisarClienteSemPassarCpfTest() {
        Cliente cliente = ComprasAmazoniaFachada.getInstance().pesquisarCliente("");
        Assert.assertNull(cliente);
    }

    @Test
    public void pesquisarProdutoTest() {
        Produto produto = ComprasAmazoniaFachada.getInstance().pesquisarProduto("P0001");
        Assert.assertEquals("P0001", produto.getCodigo());
    }

    @Test
    public void pesquisarProdutoSemPassarCodigoTest() {
        Produto produto = ComprasAmazoniaFachada.getInstance().pesquisarProduto("");
        Assert.assertNull(produto);
    }

    @Test
    public void iniciarCompraTest() {
        Assert.assertNotNull(ComprasAmazoniaFachada.getInstance().iniciarCompra());
    }

    @Test
    public void selecionarProdutoTest() {
        List<Produto> produtos = ComprasAmazoniaFachada.getInstance().listarProdutos();
        Produto produto = new Produto();
        if(!produtos.isEmpty()){
            produto = produtos.get(0);
        }
        ComprasAmazoniaFachada.getInstance().iniciarSelecaoProduto();
        ComprasAmazoniaFachada.getInstance().selecionarProduto(produto);
        List<Produto> produtosSelecionados = ComprasAmazoniaFachada.getInstance().listarProdutosSelecionados();
        if(!produtosSelecionados.isEmpty()){
            for (Produto pro:produtosSelecionados)
                if (produto.getCodigo().equals(pro.getCodigo())) {
                    Assert.assertTrue(true);
                    break;
                }
        }
    }

    @Test
    public void calulcarImpostoIsentoTest() {
        List<Produto> produtos = ComprasAmazoniaFachada.getInstance().listarProdutos();
        List<Produto> produtosIsento = new ArrayList<>();
        for (Produto pro:produtos) {
            if (pro.isIsentoImposto()){
                produtosIsento.add(pro);
                break;
            }
        }
        double valorImposto = ComprasAmazoniaFachada.getInstance().realizarCalculoImposto(produtosIsento);

        Assert.assertEquals(0L, valorImposto, 0.0);
    }

    @Test
    public void calulcarImpostoNaoIsentoTest() {
        List<Produto> produtos = ComprasAmazoniaFachada.getInstance().listarProdutos();
        List<Produto> produtosIsento = new ArrayList<>();
        for (Produto pro:produtos) {
            if (!pro.isIsentoImposto()){
                produtosIsento.add(pro);
                break;
            }
        }
        double valorImposto = ComprasAmazoniaFachada.getInstance().realizarCalculoImposto(produtosIsento);

        Assert.assertTrue(valorImposto > 0L);
    }
}
