package br.com.nwaa.entidades;

public class Email {

    private String de;
    private String para;
    private String mensagem;

    public Email() {
    }

    public Email(String de, String para, String mensagem) {
        this.de = de;
        this.para = para;
        this.mensagem = mensagem;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
