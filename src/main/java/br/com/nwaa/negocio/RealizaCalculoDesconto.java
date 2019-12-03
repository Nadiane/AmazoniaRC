package br.com.nwaa.negocio;

import br.com.nwaa.entidades.Cliente;
import br.com.nwaa.entidades.Produto;

import java.util.List;

public class RealizaCalculoDesconto {

    public double calcular(Cliente cliente, List<Produto> produtos) {
        double desconto = 0L;
        for (Produto pro : produtos) {
            if (pro.isEmPromocao()) {
                desconto = (pro.getValorUnitario() * cliente.getCupomDesconto().getDesconto()) / 100;
            }
        }
        return desconto;
    }
}
