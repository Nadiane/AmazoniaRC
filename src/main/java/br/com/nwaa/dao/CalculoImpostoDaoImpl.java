package br.com.nwaa.dao;

import br.com.nwaa.entidades.Produto;

public class CalculoImpostoDaoImpl implements IImpostoDao {

    static double ICMS = 4.5;

    public double calcularImposto(Produto pProduto) {
        return pProduto.getValor() * ICMS;
    }
}
