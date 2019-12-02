package br.com.nwaa.entidades;

public class Cliente {

    private String cpf;
    private String nome;
    private Endereco endereco;
    private Email email;
    private CupomDesconto cupomDesconto;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, Endereco endereco, Email email, CupomDesconto cupomDesconto) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.email = email;
        this.cupomDesconto = cupomDesconto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public CupomDesconto getCupomDesconto() {
        return cupomDesconto;
    }

    public void setCupomDesconto(CupomDesconto cupomDesconto) {
        this.cupomDesconto = cupomDesconto;
    }

}
