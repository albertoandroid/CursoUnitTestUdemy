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
//01 Nombrar a la Clase Test
/*
A la hora de crear la Clase test un buen estandar es llamarla como la clase que queremos testear añadiendo
la palabra test al final, es decir de forma de sufijo.
Además vemos que la estructura donde se crea CalculadoraTest esta dentro de la carpeta test a la altura de src
Es decir que tanto las clases reales y las de testeo estan dentro del mismo paquete, pero se encuentran en
un diterctorio fuente src diferente. Uno el de test y otro el main.
 */
public class CalculadoraTest {

    //02 Un poco de Teoria de lo que quermos con los test
    /*
    A la hora de hacer test unitarios lo que queremos son probar nuestros metodos
    Es decir a partir de la especificación de un metodo lo podemos probar.
    Ejemplo sumar, espera 2 parametros de entrada y dará una salida que será la suma de ambos.

    //METODO////////////////////////////////////////ESPECIFICACIOM//////////////////////////////////////////////////////////////////////////////
    int sumar(                  |Este método devuelve un int resultado de la suma de numero 1 y numero2
        int numero1,            |
        int numero2)            |
    ------------------------------------------------------------------------------------------------------------------------
    int restar(                 |Este método devuelve un int resultado de la resta de numero 1 y numero2
        int numero1,            |
        int numero2)            |
    ------------------------------------------------------------------------------------------------------------------------
    Double gradosAFahrenheit(   |Este método devuelve un double. La formula que calcula los Fahrenheit es la siguiente:
        double grados)          |                           (grados * 9/5) + 32
    ------------------------------------------------------------------------------------------------------------------------
    String calculaExperiencia(  |Este método devolverá Junior si tiene menos de 999 horas de experiencia.
        int horas)              |Devolvera SemiSenior si tiene entre 1000 y 5999 horas de experiencia
                                |Devolvera Senior si tiene entre 5999 y 19999 horas.
                                |Devolvera Maestro si tiene más de 20000 horas
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    Método a Probar                 |      Entrada      |       Salida Experarada
    sumar(int a, int b)             |a = 10, b=20       |30
    sumar(int a, int b)             |a = 7, b=4         |11
    restar(int a, int b)            |a = 7, b=4         |3
    restar(int a, int b)            |a = 10, b=20       |-10
    gradosAFahrenheit(double grados)|grados = 0         |35
    gradosAFahrenheit(double grados)|grados = 31        |87,8
    calcularExperiencia(int horas)  |horas = 500        |Junior
    calcularExperiencia(int horas)  |horas = 1234       |SeniSenior
    calcularExperiencia(int horas)  |horas = 8000       |Senior
    calcularExperiencia(int horas)  |horas = 26000      |Maestro


    Las pruebas pueden ser diseñadas y programadas antes de haber implementado el método a probar.
    De echo, te encontrarás en muchas empresas que te piden esta forma de programar.
    Básicamente de esta forma los test comprueban si el método que hemos implementado se
    ajusta a las especificaciones que nos han dado.
    Más adelante en este curso veremos esta forma. Pero por ahora vamos a lo básico de JUnit.

    Vamos a utilizar Junit para probar los metodos anteriores. Para ello siempre debemos crear una clase test.
    La forma de realizar la prueba es la siguiente:
    Invovamos al metodo que queremos probar y le pasamos los parametros de entrada que hemos establecido y para
    cada caso de prueba comprobamos que la salida real coincide con la salida esperada.

    Por supuesto esto se puede hacer sin jUNIT. pero el framework nos permite implementar purebas en un formato
    estandar que todo el mundo va a conocer y no que cada programador haga las pruebas como le apetezca.
    Además podmeos hacer los test de forma ordenada y ver sus resultados.
    Podemos ejecutar los test siempre que queramos.

    Lo básico de jUnit
    la etiqueta @Test indica que ese es un método de test. Es decir un metodo de prueba.
    En estos métodos llamaremos al método que queremos testear y veremos que el resutlado es el esperado.

    Para comprobar si el resultado del método concuerda con lo esperado tenemos los métodos Assert de la librería Junit.
    Hay diferentes tipos de Asert, luego los veremos.  AssertTrue, AssertNull, AssertEquals etc.

    Importante. Aunque podemos meter todos los Asert que queramos en un metodo de prueba lo más normal es que solo haya uno,
    debido a que son pruebas unitarias y solo quieres probar una cosa. Puesto que si metes varios asert en el mismo metodo y
    solo uno falla no lo verás tan rapidamente y se trata tambien de agilidad.

     */
    public Calculadora calculadoraNull;
    public Calculadora calculadora;

    //04 Etiqueta Before
    /*
    @Before El método con la etiqueta Before se ejecutará siempre antes de cada prueba.
    Es decir que se ejecuta antes de ejecutar cada metodo con la etiqueta test.
    Es decir, que es la opción perfecta, para inicilizar datos de entrada y salida
    que vayamos a utilizar en nuestros test.
     */
    @Before
    public void setUp(){
        calculadora = new Calculadora();
        System.out.println("Se ha ejecutado el test setUp()");
    }

    //05 Etiqueta After
    /*
    Los metodos con la etiqueta @After se ejecutan siempre despues de cada test.
    Como se puede ver, nos sirven para liberar recursos que se hubiesesn
    inicializado con el método @Before. Es decir es un método de limpieza.
    En JUnit lo solemos llamar al método tearDown
    TearDown viene a significar destruir los objetos una vez realizada la prueba.
    Es decir liberar el recurso una vez ya no es necesario.
     */
    @After
    public void tearDown(){
        calculadora = null;
        System.out.println("Se ha ejecutado el test tearDown()");
    }

    //03 Etiqueta Test y creando nuestro primer método Test
    /*
    @Test indica que ese es un método de test. Es decir un metodo de prueba.
    En estos métodos llamaremos al método que queremos testear y veremos que el resutlado es el esperado.
     */
     /*
    @Test -> A través de esta etiqueta de Junit le indicamos que se trata de un metodo de test.
    La etiqueta @Test le permite reconocer a Junit que esto es una prueba unitaria. y Tambien a nosotros como desarrolladores
    Los unit test se componen de
    1.- Etiquetas: @Test, @Before...
    2.- Afirmaciones: Que son los metodos de lo que queremos probar. AssertTrue, AssertNull, AssertEquals etc.
     */
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

    //06 Assert Teoria
    /*
    Assert Afirmaciones: Que son los metodos de lo que queremos probar.
    Los métodos Assert nos permiten comprboar si el resultado esperado es igual al resultado obtenido.
    Los métodos Assert son propios de la librería JUNIT.
    Los métodos Assert son métodos estaticos y todos ellos comienzan con el prefijo assert,
    Ejemplo:  AssertTrue, AssertNull, AssertEquals etc. Luego se veran con más detenimiento
    Al utilizar estos metodos de junit podemos saber que pruebas han tendio exito y cuales no.
    Lo bueno de este framework es que una vez ejecutado el test nos indica los metodos que lo han
    pasado y tambien los metodos que no además nos dice que resultado hemos obtenido y cual era el
    esperado.
     */

    //07 Probando Asser y Explicado al detalle
    /*
    Al principio un estandar para llamar a los test, puede ser el nombre del metodo y añadir la palabra test
    Aunque este estandar se puede mejorar como ya veremos. Al final todos tus test deberian seguir un estandar
     */

    //Método a Probar                 |      Entrada      |       Salida Experarada
    //sumar(int a, int b)             |a = 10, b=20       |30
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

    //08 Optimizando nuestro código de Test y algunas consideraciones.
    //Método a Probar                 |      Entrada      |       Salida Experarada
    //sumar(int a, int b)             |a = 10, b=20       |30
    @Test
    public void sumarTest(){
        /*
        calculadora lo coje de nuestro @Before es decir el método setup.
         */
        Assert.assertEquals(30, calculadora.sumar(10,20));
    }

    /*
    Imagina que este método se utiliza dentro de otro método, dentro de otro método y así sucesivamente.
    Según va creciendo la aplicación en el futuro al tener el código testeado no vas acarreando error.
    Lo que hace que al final se vayana multiplicando los errores y sean dificil de localizar.
    Es decir que si este método esta tres capas por debajo y falla, al final no sabes donde esta fallando
    realmente el sistema y aunque siempre se acaba encontrando el fallo te puede llevar días lo que
    para una empresa es inasumible.
    Por ello en todas las empresas grandes y empresas serias la aplicaciones son Testeadas,
    a veces por los propios desarrolladores otras por QA.
    Lo ideal es que cada nueva pieza de código que hagamos sea testeado y una vez padaso el OK,
    pasar a la siguiente con núevo código.
     */

    //09
    /*
    Comprobando que @Before se ejecuta siempre antes de cada metodo Test
    En este caso el setUp de que numero = 3;
     */

    //10 Ejemplo Assert

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


    //11 Vamos a probar los metodos con sus especificaciones
    /*
    Método a Probar                 |      Entrada      |       Salida Experarada
    sumar(int a, int b)             |a = 10, b=20       |30
    sumar(int a, int b)             |a = 7, b=4         |11
    restar(int a, int b)            |a = 7, b=4         |3
    restar(int a, int b)            |a = 10, b=20       |-10
    multiplicar(int a, int b)       |a = 4, b=10        |40


    dividir(int a, int b)           |a = 4, b=2         |2
    dividir(int a, int b)           |a = 4, b=0         |Excepción
    restar(int a, int b)            |a = 10, b=20       |-10


    gradosAFahrenheit(double grados)|grados = 0         |35
    gradosAFahrenheit(double grados)|grados = 31        |87,8
    calcularExperiencia(int horas)  |horas = 500        |Junior
    calcularExperiencia(int horas)  |horas = 1234       |SeniSenior
    calcularExperiencia(int horas)  |horas = 8000       |Senior
    calcularExperiencia(int horas)  |horas = 26000      |Maestro
     */
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
    /*
        Otra forma de nombrar los test es poniendo una explicación detallada en el nombre
        nombre metodo guión bajo y entradas y salida esperada
         */
    /*
    Una forma estandar de nombrar los test Unitarios es la siguiente:
    nombreDelMetodoATestear_entradaEsperada_comportamientoEsperado
    Ventajas:
    1.- El nombre de método de test describe a la perfección el requisito tecnico.
    2.- El nombre de método de test describe la entrada esperada y el resultado esperado para esa entrada.
    Básicamente con este nombre de test podemos saber cual es el comportamiento esperado de un método cuando recibe una entrada X
     */
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

    /*
    Junit nos permite rastrear una excepción y tambien verificar si la excpción lanzada es la esperada.
    Tenemos dos formas de hacerlo, a través del parametro opción expected en la anotación Test
    Y tambien con fail()
     */
    /*
    Expected -> Lo utilizamos cuando un metodo puede lanzar una excepcion
    La prueba fallará si el metodo no lanza la excepción
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
    /*
       En esta prueba al dividir por cero esperamos que nos lance una excepción.
       El test va a pasar debido a que si la lanza.
        */
    @Test(expected = ArithmeticException.class)
    public void dividirPorCero_NoValidInput_ExpectedException_Test(){
        calculadora.dividirPorCero(5,0);
        System.out.println("Se ha ejecutado el test dividirPorCero_NoValidInput_ExpectedException_Test()");
    }

    /*
    La etiqueta timeout en JUnit
    Un test no pasara cuando tarde ejecutarse una determinada cantidad de tiempo.
     */
    @Test(timeout = 600)
    public void operacionLargaDuracion_TimeOut_Test(){
        calculadora.operacionLargaDuracion();
    }

    /*
   La etiqueta Ignore en JUNIT.
   Ignorar un metodo a la hora de realizar el test. Tambien se puede hacer a nivel de clase.
    */
    @Ignore("Metodo no listo. Ignorar por ahora. Esperando solucionar la división por cero")
    @Test
    public void dividir_NotValidInput_Ignore_Test(){
        Assert.assertEquals(2, calculadora.dividir(5,0));
        System.out.println("Se ha ejecutado el test operacionLargaDuracion_TimeOut_Test()");
    }

}