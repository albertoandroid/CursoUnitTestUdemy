package com.androiddesdecero.testunitarios.calculadora;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */

@RunWith(value = Parameterized.class)
public class CalculadoraParametrizadaTest {

    private int numero1;
    private int numero2;
    private int resultadoExperado;
    private Calculadora calculadora;

    /*
    Ejemplo en nuestra división queremos hacer 5 pruebas
    Positivo / Positivo = Positivo
    Positivo / Negativo = Negativo
    Negativo / Positivo = Negativo
    Negativo / Negativo = Positivo
    Positivo / 0 = Excepción

    Método a Probar                 |      Entrada      |       Salida Experarada
    dividir(int a, int b)           |a = 6, b=2         |3
    dividir(int a, int b)           |a = 6, b=-2        |-3
    dividir(int a, int b)           |a = -6, b=2        |-3
    dividir(int a, int b)           |a = -6, b=-2       |3
    dividir(int a, int b)           |a = -6, b=0        |Excepción
     */

    @Parameterized.Parameters
    public static Iterable<Object[]> obtenerDatosPruebaTest(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{6,2,-3});
        list.add(new Object[]{6,-2,-3});
        list.add(new Object[]{-6,2,-3});
        list.add(new Object[]{-6,-2,3});
        list.add(new Object[]{6,0,3});
        return list;
    }

    public CalculadoraParametrizadaTest(int a, int b, int c){
        numero1 = a;
        numero2 = b;
        resultadoExperado = c;
    }

    @Before
    public void setUp(){
        calculadora = new Calculadora();
    }

    @Test
    public void dividirTest(){
        Assert.assertEquals(resultadoExperado, calculadora.dividir(numero1, numero2));
    }
}
