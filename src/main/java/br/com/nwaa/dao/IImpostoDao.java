package br.com.nwaa.dao;

import br.com.nwaa.entidades.Produto;

public interface IImpostoDao {

    public double calcularImposto(Produto pProduto);
}
