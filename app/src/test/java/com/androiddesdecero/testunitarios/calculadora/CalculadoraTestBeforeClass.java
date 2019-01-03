package com.androiddesdecero.testunitarios.calculadora;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */

/*
Fixtures ->
 */

/*
    Before Class y After Class ->
    Before Class se ejecuta una vez antes de la prueba completa. Es decir que podemos tener
    diferentes metodos test y este se ejecutará solo una vez.
    Ejemplo practico: Si instanciar una clase lleva mucho tiempo, no queremos que por cada clase
    se haga esta operación, sino que lo queremos hacer solo una vez y al principio.

    Before se ejecuta antes de cada prueba.
    La diferencia es que una solo se ejecuta una vez y la otra varias veces.

    Se podría hacer todo solo con Before, pero llevaría más tiempo, puesto que cada vez tendría que hacer esa operación de set-up de
    larga duración.
    */


public class CalculadoraTestBeforeClass {

    private static Calculadora calculadoraBefore;
    private static Calculadora caculadoraBeforeClass;

    private static int numeroBefore;
    private static int numeroBeforeClass;
    /*
    @BeforeClass -> Se ejecuta una sola vez antes de ejecutar todos los test que tenemos en esta clase.
    Lo más normal es utilizarlo por ejemplo cuando queremos probar una base de datos y queremos inicializarla esta con algún
    que otro dato, para hacer los test de CRUD, es decir create, read, update y delete de esa base de datos.
    IMPORTANTE. los metodos marcaddos con esta anotación han de ser estaticos.
     */

    @BeforeClass
    public static void beforeClass(){
        caculadoraBeforeClass = new Calculadora();
        numeroBeforeClass = 3;
        System.out.println("Se ha realiazo el beforeClass()");
    }

    @Before
    public void before(){
        calculadoraBefore = new Calculadora();
        numeroBefore = 3;
        System.out.println("Se ha realiazo el before()");
    }

    @Test
    public void pruebaBeforeVsBeforeClass(){
        numeroBeforeClass = numeroBeforeClass + 3;
        numeroBefore = numeroBefore + 3;
        Assert.assertEquals("numeroBeforeClass: ", 6, numeroBeforeClass);
        Assert.assertEquals("numeroBefore: ", 6, numeroBefore);
        System.out.println("Se ha realiazo el pruebaBeforeVsBeforeClass()");

    }

    @Test
    public void pruebaBeforeVsBeforeClass2(){
        numeroBeforeClass = numeroBeforeClass + 3;
        numeroBefore = numeroBefore + 3;
        Assert.assertEquals("numeroBeforeClass: ", 9, numeroBeforeClass);
        Assert.assertEquals("numeroBefore: ", 6, numeroBefore);
        System.out.println("Se ha realiazo el pruebaBeforeVsBeforeClass2()");

    }

    /*
    AfterClass se ejecuta solo una vez despues de todos los test de clase. Su objetivo como nos
    podemos imaginar es liberar los recursos inicializados en el método marcado como @BeforeClass y es
    para metodos estaticos.
     */
    @AfterClass
    public static void afterClass(){
        caculadoraBeforeClass = null;
        numeroBeforeClass = 0;
        System.out.println("Se ha realiado afterClass()");
    }
    /*
    Se ejecuta despues de cada test. Nos sirve para liberar recursos que hemos inicializado eon el metodo @Before
     */
    @After
    public void after(){
        calculadoraBefore = null;
        numeroBefore = 0;
        System.out.println("Se ha realiado after()");
    }
}
