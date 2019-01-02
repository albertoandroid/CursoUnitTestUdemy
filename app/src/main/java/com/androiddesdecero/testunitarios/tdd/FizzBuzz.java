package com.androiddesdecero.testunitarios.tdd;

/**
 * Created by albertopalomarrobledo on 2/1/19.
 */

public class FizzBuzz {

    public String of(int numero){

        if(numero == 0){
            return "0";
        }

        if(numero % 3 == 0 && numero % 5 == 0){
            return "FizzBuzz";
        }
        if(numero % 3 == 0){
            return "Fizz";
        }
        if(numero % 5 == 0){
            return "Buzz";
        }
        return String.valueOf(numero);
    }
}
