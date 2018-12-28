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

public class CalculadoraTestBeforeClass {

    private static Calculadora calculadoraBefore;
    private static Calculadora caculadoraBeforeClass;

    private static int numeroBefore;
    private static int numeroBeforeClass;

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

    @AfterClass
    public static void afterClass(){
        caculadoraBeforeClass = null;
        numeroBeforeClass = 0;
        System.out.println("Se ha realiado afterClass()");
    }

    @After
    public void after(){
        calculadoraBefore = null;
        numeroBefore = 0;
        System.out.println("Se ha realiado after()");
    }
}
