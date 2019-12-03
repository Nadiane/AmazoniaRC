package br.com.nwaa.entidades;

import br.com.nwaa.constantes.Constantes;
import br.com.nwaa.util.Util;

public class Entrega {

    private String cepOrigem;
    private String cepDestino;
    private double peso;
    private double valor;

    public Entrega() {
    }

    public Entrega(String cepOrigem, String cepDestino, double peso, double valor) {
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.peso = peso;
        this.valor = valor;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public void setCepOrigem(String cepOrigem) {
        this.cepOrigem = cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "CEP Origem: " + Util.formatarValor(cepOrigem, Constantes.FORMATO_CEP) + "\nCEP Destino: " + Util.formatarValor(cepDestino, Constantes.FORMATO_CEP) + "\nPeso Total: " + peso;
    }
}
