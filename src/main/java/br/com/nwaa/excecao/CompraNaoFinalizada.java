package br.com.nwaa.excecao;

public class CompraNaoFinalizada extends Exception{

    public String getMensagem(){
        return "Compra não finalizada!";
    }
}
