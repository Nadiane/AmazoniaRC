package br.com.nwaa.negocio;

import br.com.nwaa.entidades.Entrega;
import br.com.nwaa.entidades.Frete;
import br.com.nwaa.entidades.Produto;
import br.com.nwaa.servico.frete.CalculoFreteService;

import java.util.List;

public class RealizaCalculoFrete {

    CalculoFreteService calculoFreteService;

    public RealizaCalculoFrete() {
        this.calculoFreteService = new CalculoFreteService();
    }

    public Frete calcular(Entrega entrega, List<Produto> produtos){
        Frete frete = new Frete();
        for (Produto produto:produtos) {
            if(!produto.isMidiaDigital()){
                double pesoTotal =+ produto.getPeso();
                entrega.setPeso(pesoTotal);
                frete = calculoFreteService.calcularFrete(entrega);
            }
        }
        return frete;
    }

}
