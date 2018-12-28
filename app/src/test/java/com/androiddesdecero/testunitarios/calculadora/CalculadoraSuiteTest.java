package com.androiddesdecero.testunitarios.calculadora;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */

@RunWith(value = Suite.class)
@Suite.SuiteClasses({
        CalculadoraParametrizadaTest.class,
        CalculadoraTest.class
})
public class CalculadoraSuiteTest {

}
