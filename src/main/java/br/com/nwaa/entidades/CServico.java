package br.com.nwaa.entidades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cServico")
@XmlAccessorType(XmlAccessType.FIELD)
public class CServico {

    private String Codigo;
    private String Valor;
    private String PrazoEntrega;
    private String ValorSemAdicionais;
    private String ValorMaoPropria;
    private String ValorAvisoRecebimento;
    private String ValorValorDeclarado;
    private String EntregaDomiciliar;
    private String EntregaSabado;
    //    private String obsFim;
    private String Erro;
    private String MsgErro;

    @XmlElement
    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    @XmlElement
    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    @XmlElement
    public String getPrazoEntrega() {
        return PrazoEntrega;
    }

    public void setPrazoEntrega(String PrazoEntrega) {
        this.PrazoEntrega = PrazoEntrega;
    }

    @XmlElement
    public String getValorSemAdicionais() {
        return ValorSemAdicionais;
    }

    public void setValorSemAdicionais(String ValorSemAdicionais) {
        this.ValorSemAdicionais = ValorSemAdicionais;
    }

    @XmlElement
    public String getValorMaoPropria() {
        return ValorMaoPropria;
    }

    public void setValorMaoPropria(String ValorMaoPropria) {
        this.ValorMaoPropria = ValorMaoPropria;
    }

    @XmlElement
    public String getValorAvisoRecebimento() {
        return ValorAvisoRecebimento;
    }

    public void setValorAvisoRecebimento(String ValorAvisoRecebimento) {
        this.ValorAvisoRecebimento = ValorAvisoRecebimento;
    }

    @XmlElement
    public String getValorValorDeclarado() {
        return ValorValorDeclarado;
    }

    public void setValorValorDeclarado(String ValorValorDeclarado) {
        this.ValorValorDeclarado = ValorValorDeclarado;
    }

    @XmlElement
    public String getEntregaDomiciliar() {
        return EntregaDomiciliar;
    }

    public void setEntregaDomiciliar(String EntregaDomiciliar) {
        this.EntregaDomiciliar = EntregaDomiciliar;
    }

    @XmlElement
    public String getEntregaSabado() {
        return EntregaSabado;
    }

    public void setEntregaSabado(String EntregaSabado) {
        this.EntregaSabado = EntregaSabado;
    }

//    @XmlElement
//    public String getObsFim() {
//        return obsFim;
//    }
//
//    public void setObsFim(String obsFim) {
//        this.obsFim = obsFim;
//    }

    @XmlElement
    public String getErro() {
        return Erro;
    }

    public void setErro(String Erro) {
        this.Erro = Erro;
    }

    @XmlElement
    public String getMsgErro() {
        return MsgErro;
    }

    public void setMsgErro(String MsgErro) {
        this.MsgErro = MsgErro;
    }
}
