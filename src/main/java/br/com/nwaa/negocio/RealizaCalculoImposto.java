package br.com.nwaa.negocio;

import br.com.nwaa.entidades.Produto;
import br.com.nwaa.util.Util;

import java.util.List;

public class RealizaCalculoImposto implements IRealizaCalculo {

    private static double ICMS = 1.5;

    private List<Produto> produtos;

    public RealizaCalculoImposto(List<Produto> pProdutos){
        this.produtos = pProdutos;
    }

    @Override
    public double calcular() {
        double valorImposto = 0L;
        for (Produto pro:produtos) {
            if(!pro.isIsentoImposto()){
                pro.setValorImposto(Util.arredondar((pro.getValorUnitario() * ICMS) - pro.getValorUnitario()));
                valorImposto = valorImposto + (pro.getValorImposto());
            }
        }
        return Util.arredondar(valorImposto);
    }
}
