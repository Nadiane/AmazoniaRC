package br.com.nwaa.entidades;

public class Produto {

    private String nome;
    private String descricao;
    private double valor;
    private int quantidade;
    private double peso;
    private boolean midiaDigital;
    private boolean emPromocao;
    private boolean isentoImposto;

    public Produto() {
    }

    public Produto(String nome, String descricao, double valor, int quantidade, double peso, boolean midiaDigital, boolean emPromocao, boolean isentoImposto) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        this.peso = peso;
        this.midiaDigital = midiaDigital;
        this.emPromocao = emPromocao;
        this.isentoImposto = isentoImposto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isMidiaDigital() {
        return midiaDigital;
    }

    public void setMidiaDigital(boolean midiaDigital) {
        this.midiaDigital = midiaDigital;
    }

    public boolean isEmPromocao() {
        return emPromocao;
    }

    public void setEmPromocao(boolean emPromocao) {
        this.emPromocao = emPromocao;
    }

    public boolean isIsentoImposto() {
        return isentoImposto;
    }

    public void setIsentoImposto(boolean isentoImposto) {
        this.isentoImposto = isentoImposto;
    }
}
