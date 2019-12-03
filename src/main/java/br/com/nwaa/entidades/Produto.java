package br.com.nwaa.entidades;

public class Produto {

    private String codigo;
    private String nome;
    private String descricao;
    private double valorUnitario;
    private double valorImposto;
    private int quantidade;
    private double peso;
    private boolean midiaDigital;
    private boolean emPromocao;
    private boolean isentoImposto;

    public Produto() {
    }

    public Produto(String codigo, String nome, String descricao, double valorUnitario, double valorImposto, int quantidade, double peso, boolean midiaDigital, boolean emPromocao, boolean isentoImposto) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.valorImposto = valorImposto;
        this.quantidade = quantidade;
        this.peso = peso;
        this.midiaDigital = midiaDigital;
        this.emPromocao = emPromocao;
        this.isentoImposto = isentoImposto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorImposto() {
        return valorImposto;
    }

    public void setValorImposto(double valorImposto) {
        this.valorImposto = valorImposto;
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
