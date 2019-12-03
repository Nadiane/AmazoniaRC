package br.com.nwaa.servico.email;

import br.com.nwaa.entidades.Email;

public interface IEmail {

    boolean enviarEmail(Email email);
}
