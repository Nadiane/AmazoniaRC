package br.com.nwaa.fachada;

import br.com.nwaa.dao.DadosDao;
import br.com.nwaa.dao.IDados;
import br.com.nwaa.entidades.Cliente;
import br.com.nwaa.negocio.Negocio;
import br.com.nwaa.negocio.RealizaCalculoDesconto;
import br.com.nwaa.negocio.RealizaCalculoFrete;
import br.com.nwaa.negocio.RealizaCalculoImpostoImpl;

public class ComprasAmazoniaFachada {

    private static ComprasAmazoniaFachada fachada;
    private Negocio negocio;

    RealizaCalculoImpostoImpl calculoImposto = null;
    RealizaCalculoDesconto calculoDesconto = null;
    RealizaCalculoFrete realizaCalculoFrete = null;

    public ComprasAmazoniaFachada() {
        IDados idados = new DadosDao();
        negocio = new Negocio(idados);
    }

    public ComprasAmazoniaFachada(RealizaCalculoImpostoImpl calculoImposto, RealizaCalculoDesconto calculoDesconto, RealizaCalculoFrete realizaCalculoFrete) {
        this.calculoImposto = calculoImposto;
        this.calculoDesconto = calculoDesconto;
        this.realizaCalculoFrete = realizaCalculoFrete;
    }

    public static ComprasAmazoniaFachada getInstance(){
        if (fachada == null){
            fachada = new ComprasAmazoniaFachada();
        }
        return fachada;
    }

    public Cliente pesquisarCliente(String cpf) {
        return negocio.pesquisarCliente(cpf);
    }
}
