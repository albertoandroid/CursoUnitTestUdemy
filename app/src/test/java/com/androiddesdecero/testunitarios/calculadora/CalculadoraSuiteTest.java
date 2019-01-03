package com.androiddesdecero.testunitarios.calculadora;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */
/*
Suite.class
Cuando anotamos con la clase @RunWith(value = Suite.class) Nos permite crear manualmente una suite que contenga test
de diferentes clases. Las Clase que forman parte de nuestra suite se incluyen a través de la anotación @Suite
Que no solo indica las clases que se incluirán sino tambien indica el orden en el que se ejecutarán dichos test.
 */
/*
El ejemplo tipico es cuando tienes que hacer pruebas que esten entrelazadas.
Ejemplo quieres testear los metodos Insertar y Leer en una base de datos.
Primero tienes que insertar el Dato y luego leerlo. Si lo hicieras al reves no habría dato que leer.
Y para ello necesitas que los test vayan en un orden indicado.
 */

@RunWith(value = Suite.class)
@Suite.SuiteClasses({
        CalculadoraParametrizadaTest.class,
        CalculadoraTest.class
})
public class CalculadoraSuiteTest {

}
