package br.com.nwaa.negocio;

import br.com.nwaa.entidades.Entrega;
import br.com.nwaa.entidades.Frete;
import br.com.nwaa.entidades.Produto;
import br.com.nwaa.servico.frete.CalculoFreteService;

import java.util.List;

public class RealizaCalculoFrete implements IRealizaCalculo{

    private Entrega entrega;
    private List<Produto> produtos;
    private CalculoFreteService calculoFreteService;

    public RealizaCalculoFrete(Entrega pEntrega,List<Produto> pProdutos) {
        this.entrega = pEntrega;
        this.produtos = pProdutos;
        this.calculoFreteService = new CalculoFreteService();
    }

    @Override
    public double calcular() {
        Frete frete = new Frete();
        for (Produto produto:produtos) {
            if(!produto.isMidiaDigital()){
                double pesoTotal =+ produto.getPeso();
                entrega.setPeso(pesoTotal);
                frete = calculoFreteService.calcularFrete(entrega);
            }
        }
        return frete.getValor();
    }
}
