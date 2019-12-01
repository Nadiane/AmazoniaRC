package br.com.nwaa.entidades;

public class CupomDesconto {

    private String codigo;
    private int desconto;

    public CupomDesconto() {
    }

    public CupomDesconto(String codigo, int desconto) {
        this.codigo = codigo;
        this.desconto = desconto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
}
