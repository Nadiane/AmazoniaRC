package br.com.nwaa;

import br.com.nwaa.entidades.Cliente;
import br.com.nwaa.entidades.Compra;
import junit.framework.TestCase;
import org.jetbrains.annotations.TestOnly;

public class ComprasAmazoniaTest extends TestCase {

    public void pesquisarCliente(){
        Cliente cliente = ComprasAmazoniaFachada.pesquisarCliente("01234567890");
        assertTrue(cliente.getCpf().equals("01234567890"));
    }

    public void pesquisarClienteNaoExistente(){
        Cliente cliente = ComprasAmazoniaFachada.pesquisarCliente("32145609871");
        assertTrue(cliente == null);
    }


}
