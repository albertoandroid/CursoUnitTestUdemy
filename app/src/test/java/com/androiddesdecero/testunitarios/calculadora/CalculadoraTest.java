package com.androiddesdecero.testunitarios.calculadora;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */
public class CalculadoraTest {

    public Calculadora calculadoraNull;

    @Test
    public void caculadoraNullTest(){
        Assert.assertNull("Calculadora debe ser null", calculadoraNull);
        System.out.println("Se ha ejecutado el test caculadoraNullTest");
    }

    /*
    Método a Probar                 |      Entrada      |       Salida Experarada
    sumar(int a, int b)             |a = 10, b=20       |30
    sumar(int a, int b)             |a = 7, b=4         |11
    restar(int a, int b)            |a = 7, b=4         |3
    restar(int a, int b)            |a = 10, b=20       |-10
    */
    @Test
    public void sumar() throws Exception {
    }

    @Test
    public void restar() throws Exception {
    }

}