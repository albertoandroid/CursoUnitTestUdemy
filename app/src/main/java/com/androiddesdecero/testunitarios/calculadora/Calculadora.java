package com.androiddesdecero.testunitarios.calculadora;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */

public class Calculadora {
    /*
    //METODO////////////////////////////////////////ESPECIFICACIOM//////////////////////////////////////////////////////////////////////////////
    int sumar(                  |Este método devuelve un int resultado de la suma de numero 1 y numero2
        int numero1,            |
        int numero2)            |
    ------------------------------------------------------------------------------------------------------------------------
    int restar(                 |Este método devuelve un int resultado de la resta de numero 1 y numero2
        int numero1,            |
        int numero2)            |
    ------------------------------------------------------------------------------------------------------------------------
     */

    private int resutado;

    public int sumar(int numero1, int numero2){
        resutado = numero1 + numero2;
        return resutado;
    }

    public int restar(int numero1, int numero2){
        resutado = numero1 - numero2;
        return resutado;
    }
}
