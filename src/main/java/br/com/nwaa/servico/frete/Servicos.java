package br.com.nwaa.servico.frete;

import br.com.nwaa.entidades.CServico;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Servicos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Servicos {

    private List<CServico> servicos = null;

    @XmlElement(name = "cServico")
    public List<CServico> getcServico() {
        return servicos;
    }

    public void setcServico(List<CServico> servicos) {
        this.servicos = servicos;
    }
}

