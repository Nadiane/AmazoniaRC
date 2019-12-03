package br.com.nwaa.negocio;

import br.com.nwaa.dao.IDados;
import br.com.nwaa.entidades.Cliente;

public class Negocio {

    private IDados idados;

    public Negocio(IDados idados) {
        this.idados = idados;
    }

    public Cliente pesquisarCliente(String cpf) {
        if (cpf == "") {
            return null;
        }
        else {
            return idados.pesquisarCliente(cpf);
        }
    }
}
