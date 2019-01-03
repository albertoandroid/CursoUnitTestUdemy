package com.androiddesdecero.testunitarios.tdd;

/**
 * Created by albertopalomarrobledo on 2/1/19.
 */

/*
FizzBuzz es un juego para que los niños les enseñen la división.
El juego consiste en reemplazar cualquier número divisible por tres
con la palabra fizz y cualquier número divisible por cinco por la palabra
Buzz y si es divisible entre 3 y 5 sustituirlo por FizzBuzz

Este ejemplos es ideal cuando se quiere hacer TDD como veremos a continuación


Dado un número entero mayor o igual que cero:
    1.- Si es divisible por 3 entonces devolver "Fizz"
    2.- Si es divisible por 5 entonces devolver "Buzz"
    3.- Si es divisible por 3 y 5 entonces devolver "FizzBuzz"
    4.- Si nada de lo de arriba ocurre devolver el número
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
