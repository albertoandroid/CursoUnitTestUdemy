package com.androiddesdecero.testunitarios.calculadora;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */

@RunWith(value = Parameterized.class)
public class CalculadoraParametrizadaTest {

    private int numero1;
    private int numero2;
    private int resultadoExperado;
    private Calculadora calculadora;
}
