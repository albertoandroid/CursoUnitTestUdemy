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

/*
@Runwith
Cuando marcamos una clase test con @Runwith, Junit invoca a la clase que se le indica en la anotación
para lanzar los tests.
Si no se pone nada el lanzador por defecto es BlockJUnit4ClassRunner
Basicamente nos permite configurar el runner de los test. En este ejemplo vamos a ver con Parameterized.
Pero tambien veremos con Mockito, y Suite.

Parameterized es un runner de Junit.
La prueba parametrizada consiste en ejecutar la misma prueba una y otra vez utilizando diferentes valores.
Nos ayuda a los desarroladores a ahorrar tiempo en la ejecución de la misma.
Es decir que podemos pasar las entradas y los resultados esperados.
Con la pruegba parametrizada se puede configurar un test que obtiene los datos de alguna fuente de datos,
base de datos, web service, etc...

Parameterized.class
Cuando anotamos con la clase @RunWith(value = Parameterized.class) se crearán tantas instancias y se ejecutarán
tantas veces los métodos como parámetros indicamos en el método anotado con @Parameters
 */


@RunWith(value = Parameterized.class)
public class CalculadoraParametrizadaTest {

    private int numero1;
    private int numero2;
    private int resultadoExperado;
    private Calculadora calculadora;

    /*
    Parameterized Test - Prueba Parametrizada
    Las pruebas parametrizadas consisten en ejecutar la misma prueba una y otra vez utilizando valores diferentes.
    Nos ayuda a ahorrar tiempo.
    Es ideal cuando estos datos los quieres traer de una base de datos local o de un servidor.
    */

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

    /*
    Cuando antoamos con @RunWith(value = Parameterized.class) busca el metodo anotado con @Parameteres
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

    /*
    Este constructor es llamado por Junit con los parametros que le pasamos.
     */
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
