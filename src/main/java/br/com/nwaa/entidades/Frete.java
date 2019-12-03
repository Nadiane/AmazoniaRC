package br.com.nwaa.entidades;

public class Frete {

    private int codigo;
    private double valor;
    private int prazoEntrega;
    private double valorSemAdicionais;
    private double valorMaoPropria;
    private double valorAvisoRecebimento;
    private double valorValorDeclarado;
    private String entregaDomiciliar;
    private String entregaSabado;
    private String obsFim;
    private int erro;
    private String msgErro;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(int prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public double getValorSemAdicionais() {
        return valorSemAdicionais;
    }

    public void setValorSemAdicionais(double valorSemAdicionais) {
        this.valorSemAdicionais = valorSemAdicionais;
    }

    public double getValorMaoPropria() {
        return valorMaoPropria;
    }

    public void setValorMaoPropria(double valorMaoPropria) {
        this.valorMaoPropria = valorMaoPropria;
    }

    public double getValorAvisoRecebimento() {
        return valorAvisoRecebimento;
    }

    public void setValorAvisoRecebimento(double valorAvisoRecebimento) {
        this.valorAvisoRecebimento = valorAvisoRecebimento;
    }

    public double getValorValorDeclarado() {
        return valorValorDeclarado;
    }

    public void setValorValorDeclarado(double valorValorDeclarado) {
        this.valorValorDeclarado = valorValorDeclarado;
    }

    public String getEntregaDomiciliar() {
        return entregaDomiciliar;
    }

    public void setEntregaDomiciliar(String entregaDomiciliar) {
        this.entregaDomiciliar = entregaDomiciliar;
    }

    public String getEntregaSabado() {
        return entregaSabado;
    }

    public void setEntregaSabado(String entregaSabado) {
        this.entregaSabado = entregaSabado;
    }

    public String getObsFim() {
        return obsFim;
    }

    public void setObsFim(String obsFim) {
        this.obsFim = obsFim;
    }

    public int getErro() {
        return erro;
    }

    public void setErro(int erro) {
        this.erro = erro;
    }

    public String getMsgErro() {
        return msgErro;
    }

    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }
}
