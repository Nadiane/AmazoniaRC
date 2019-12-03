package br.com.nwaa.negocio;

import br.com.nwaa.entidades.Produto;

public class RealizaCalculoImpostoImpl implements IRealizaCalculoImposto {

    static double ICMS = 4.5;

    public double calcularImposto(Produto pProduto) {
        return pProduto.getValorUnitario() * ICMS;
    }
}
