package br.com.nwaa.servico.frete;

import br.com.nwaa.entidades.CServico;
import br.com.nwaa.entidades.Entrega;
import br.com.nwaa.entidades.Frete;
import br.com.nwaa.util.Util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CalculoFreteService {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String CEP_ORIGEM = "51021520";

    public Frete calcularFrete(Entrega entrega) {
        String url = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?sCepOrigem=" + CEP_ORIGEM + "&sCepDestino=" + entrega.getCepDestino()
                + "&nVlPeso=" + entrega.getPeso() + "&nVlComprimento=30&nVlAltura=2&nVlLargura=15&nVlDiametro=0.0&nCdFormato=1&sCdMaoPropria=N&sCdAvisoRecebimento=N"
                + "&nVlValorDeclarado=0,00&nCdServico=04510&nCdEmpresa=&sDsSenha=&StrRetorno=xml";

        Servicos servicos = new Servicos();

        try {
            String retornoXML = sendGet(url, "GET");

            StringReader reader = new StringReader(retornoXML);
            JAXBContext jaxbContext = null;

            jaxbContext = JAXBContext.newInstance(Servicos.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            servicos = (Servicos) unmarshaller.unmarshal(reader);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return converterParaObjetoFrete(servicos);
    }

    private Frete converterParaObjetoFrete(Servicos servicos) {
        Frete frete = new Frete();
        for (CServico cServico : servicos.getcServico()) {
            if (cServico != null) {
                frete.setCodigo(Integer.parseInt(cServico.getCodigo()));
                frete.setValor(Util.converterStringEmDouble(cServico.getValor()));
                frete.setPrazoEntrega(Integer.parseInt(cServico.getPrazoEntrega()));
                frete.setValorSemAdicionais(Util.converterStringEmDouble(cServico.getValorSemAdicionais()));
                frete.setValorMaoPropria(Util.converterStringEmDouble(cServico.getValorMaoPropria()));
                frete.setValorAvisoRecebimento(Util.converterStringEmDouble(cServico.getValorAvisoRecebimento()));
                frete.setValorValorDeclarado(Util.converterStringEmDouble(cServico.getValorValorDeclarado()));
                frete.setEntregaDomiciliar(cServico.getEntregaDomiciliar());
                frete.setEntregaSabado(cServico.getEntregaSabado());
            }
        }
        return frete;
    }

    private static String sendGet(String url, String method) throws Exception {

        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod(method);

        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

        StringBuffer response = new StringBuffer();
        String inputLine;

        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }
        br.close();

        return response.toString();

    }

}
