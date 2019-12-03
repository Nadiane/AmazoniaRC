package br.com.nwaa.util;

import br.com.nwaa.constantes.Constantes;
import sun.rmi.runtime.Log;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class Util {

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

    public static String formatarValor(String valor, String formato){
        try {
            MaskFormatter mask = new MaskFormatter(formato);
            mask.setValueContainsLiteralCharacters(false);
            valor = mask.valueToString(valor);
        } catch (ParseException ex) {
            Log.getLog(ex.getMessage(), "", 0);
        }
        return valor;
    }

}
