package com.androiddesdecero.testunitarios.calculadora;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
    public void ejemploAssert(){
        Assert.assertTrue(1==1);
        Assert.assertFalse(1==2);

        //Assert.assertNull(calculadora);
        Assert.assertNotNull(calculadora);

        Calculadora calculadora1 = new Calculadora();
        Calculadora calculadora2 = new Calculadora();
        Calculadora calculadora3 = calculadora1;

     //   Assert.assertSame(calculadora1, calculadora2);
        Assert.assertSame(calculadora1, calculadora3);
        Assert.assertNotSame(calculadora1, calculadora2);

        Assert.assertEquals("a", "a");
    //    Assert.assertEquals("Esto es una prueba AssertEqucals con error fa no es a", "Fa", "a");

        Assert.assertEquals(1, 1.4, 0.5);

      //  Assert.fail("Fallo detectado Manuelmente");
    }



    @Test
    public void sumar() throws Exception {
        //SetUp
        int a = 10;
        int b = 20;
        int resutladoExperado = 30;
        int resultado;
        //Acción
        resultado = calculadora.sumar(a,b);
        //Assert
        Assert.assertEquals(resutladoExperado, resultado);
    }

    @Test
    public void sumar_ValidInput_ValidExpected_Test(){
        Assert.assertEquals(11, calculadora.sumar(7,4));
        System.out.println("Se ha ejecutado el test sumar_ValidInput_ValidExpected_Test()");
    }

    /*
    Método a Probar                 |      Entrada      |       Salida Experarada
    sumar(int a, int b)             |a = 10, b=20       |30
    sumar(int a, int b)             |a = 7, b=4         |11
    restar(int a, int b)            |a = 7, b=4         |3
    restar(int a, int b)            |a = 10, b=20       |-10
    */

    @Test
    public void restar_ValidInput_ValidExpeted_Test() throws Exception {
        Assert.assertEquals(3, calculadora.restar(7,4));
        System.out.println("Se ha ejecutado el test sumar_ValidInput_ValidExpected_Test()");
    }

    @Test
    public void restar_ValidInput_ValidNegativeExpeted_Test() throws Exception {
        Assert.assertEquals(-10, calculadora.restar(10,20));
        System.out.println("Se ha ejecutado el test restar_ValidInput_ValidNegativeExpeted_Test()");
    }

    /*
    Método a Probar                 |      Entrada      |       Salida Experarada
    dividir(int a, int b)           |a = 4, b=2         |2
    dividir(int a, int b)           |a = 4, b=0         |Excepción
    */

    @Test
    public void dividir_ValidInput_ValidExpected_Test(){
        Assert.assertEquals(2, calculadora.dividir(4,2));
        System.out.println("Se ha ejecutado el test dividir_ValidInput_ValidExpected_Test()");
    }

    @Test
    public void dividir_NotValidInput_Test(){
        calculadora.dividir(5,0);
        System.out.println("Se ha ejecutado el test dividir_NotValidInput_Test");
        Assert.fail("Fallo detectado Manuelmente - No se puede dividir por Cero");
    }

    @Test(expected = ArithmeticException.class)
    public void dividirPorCero_NoValidInput_ExpectedException_Test(){
        calculadora.dividirPorCero(5,0);
        System.out.println("Se ha ejecutado el test dividirPorCero_NoValidInput_ExpectedException_Test()");
    }

    @Test(timeout = 600)
    public void operacionLargaDuracion_TimeOut_Test(){
        calculadora.operacionLargaDuracion();
    }

    @Ignore("Metodo no listo. Ignorar por ahora. Esperando solucionar la división por cero")
    @Test
    public void dividir_NotValidInput_Ignore_Test(){
        Assert.assertEquals(2, calculadora.dividir(5,0));
        System.out.println("Se ha ejecutado el test operacionLargaDuracion_TimeOut_Test()");
    }

}