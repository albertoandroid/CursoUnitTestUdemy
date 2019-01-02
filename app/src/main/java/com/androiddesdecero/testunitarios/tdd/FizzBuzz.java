package com.androiddesdecero.testunitarios.tdd;

/**
 * Created by albertopalomarrobledo on 2/1/19.
 */

public class FizzBuzz {

    public String of(int numero){

        if(numero == 0){
            return "0";
        }

        String texto = "";

        if(numero % 3 == 0){
            texto += "Fizz";
        }
        if(numero % 5 == 0){
            texto += "Buzz";
        }

        return texto.isEmpty() ? String.valueOf(numero) : texto;
    }
}
