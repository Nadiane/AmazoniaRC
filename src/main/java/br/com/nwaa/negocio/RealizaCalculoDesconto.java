package br.com.nwaa.negocio;

import br.com.nwaa.entidades.Cliente;
import br.com.nwaa.entidades.Produto;

import java.util.List;

public class RealizaCalculoDesconto implements IRealizaCalculo {

    private Cliente cliente;
    private List<Produto> produtos;

    public RealizaCalculoDesconto(Cliente pCliente, List<Produto> pProdutos) {
        this.cliente = pCliente;
        this.produtos = pProdutos;
    }

    @Override
    public double calcular() {
        double desconto = 0L;
        for (Produto pro : produtos) {
            if (pro.isEmPromocao() && cliente.getCupomDesconto() != null)
                desconto = (pro.getValorUnitario() * cliente.getCupomDesconto().getDesconto()) / 100;
        }
        return desconto;
    }
}
