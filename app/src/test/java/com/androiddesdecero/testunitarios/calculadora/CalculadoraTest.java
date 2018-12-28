package com.androiddesdecero.testunitarios.calculadora;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */
public class CalculadoraTest {

    public Calculadora calculadoraNull;
    public Calculadora calculadora;

    @Before
    public void setUp(){
        calculadora = new Calculadora();
        System.out.println("Se ha ejecutado el test setUp()");
    }

    @After
    public void tearDown(){
        calculadora = null;
        System.out.println("Se ha ejecutado el test tearDown()");
    }

    @Test
    public void caculadoraNotNullTest(){
        Assert.assertNotNull("Calculadora debe ser not null", calculadora);
        System.out.println("Se ha ejecutado el test caculadoraNotNullTest()");
    }

    @Test
    public void caculadoraNullTest(){
        Assert.assertNull("Calculadora debe ser null", calculadoraNull);
        System.out.println("Se ha ejecutado el test caculadoraNullTest()");
    }

    /*
    Método a Probar                 |      Entrada      |       Salida Experarada
    sumar(int a, int b)             |a = 10, b=20       |30
    sumar(int a, int b)             |a = 7, b=4         |11
    restar(int a, int b)            |a = 7, b=4         |3
    restar(int a, int b)            |a = 10, b=20       |-10
    */

    @Test
    public void sumarTestExplicado(){
        //Setup
        Calculadora calculadoraPrueba = new Calculadora();
        int resultadoExperado = 30;
        int restuladoActual;
        //Acción
        restuladoActual = calculadoraPrueba.sumar(10, 20);
        //Assert
        //Assert.assertEquals(resultadoExperado, restuladoActual);
        Assert.assertEquals(30, calculadoraPrueba.sumar(10,20));
        System.out.println("Se ha ejecutado el test sumarTestExplicado()");

    }

    @Test
    public void sumarTest(){
        Assert.assertEquals(30, calculadora.sumar(10,20));
    }



    @Test
    public void sumar() throws Exception {
    }

    @Test
    public void restar() throws Exception {
    }

}