package br.com.nwaa.util;

public class Util {


    /**
     * 1 - Valor a arredondar.
     * 2 - Quantidade de casas depois da vírgula.
     * 3 - Arredondar para cima ou para baixo?
     * Para cima = 0 (ceil)
     * Para baixo = 1 ou qualquer outro inteiro (floor)
     **/
    public static double arredondar(double valor) {
        double arredondado = valor;
        arredondado *= (Math.pow(10, 2));
        arredondado = Math.ceil(arredondado);
        arredondado /= (Math.pow(10, 2));
        return arredondado;
    }

    public static double converterStringEmDouble(String valorString){
        valorString = valorString.replace(',', '.');
        return Double.parseDouble(valorString);
    }

}
