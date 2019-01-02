package com.androiddesdecero.testunitarios.tdd;

/**
 * Created by albertopalomarrobledo on 2/1/19.
 */

public class FizzBuzz {

    public String of(int numero){
        if(numero == 3){
            return "Fizz";
        }
        return String.valueOf(numero);
    }
}
