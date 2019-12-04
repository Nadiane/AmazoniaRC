package br.com.nwaa;

import br.com.nwaa.entidades.Cliente;
import br.com.nwaa.entidades.Produto;
import br.com.nwaa.fachada.ComprasAmazoniaFachada;
import org.junit.Assert;
import org.junit.Test;

public class ComprasAmazoniaTest {

    @Test
    public void pesquisarClienteTest() {
        Cliente cliente = ComprasAmazoniaFachada.getInstance().pesquisarCliente("01234567890");
        Assert.assertTrue(cliente.getCpf().equals("01234567890"));
    }

    @Test
    public void pesquisarClienteNaoExistenteTest() {
        Cliente cliente = ComprasAmazoniaFachada.getInstance().pesquisarCliente("32145609871");
        Assert.assertTrue(cliente == null);
    }

    @Test
    public void pesquisarClienteSemPassarCpfTest() {
        Cliente cliente = ComprasAmazoniaFachada.getInstance().pesquisarCliente("");
        Assert.assertTrue(cliente == null);
    }

    @Test
    public void pesquisarProdutoTest() {
        Produto produto = ComprasAmazoniaFachada.getInstance().pesquisarProduto("P0001");
        Assert.assertTrue(produto.getCodigo().equals("P0001"));
    }

    @Test
    public void pesquisarProdutoSemPassarCodigoTest() {
        Produto produto = ComprasAmazoniaFachada.getInstance().pesquisarProduto("");
        Assert.assertTrue(produto == null);
    }

    @Test
    public void iniciarCompraTest() {
        Assert.assertTrue(ComprasAmazoniaFachada.getInstance().iniciarCompra() != null);
    }

    @Test
    public void adicionarProdutosCompraTest() {
        Produto produto = new Produto();

        Assert.assertTrue(ComprasAmazoniaFachada.getInstance().adicionarProdutosCompra(); != null);
    }
}
