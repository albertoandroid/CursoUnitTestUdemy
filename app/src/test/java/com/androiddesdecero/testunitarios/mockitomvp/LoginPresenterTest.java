package com.androiddesdecero.testunitarios.mockitomvp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */
//Para Correr el Test con Mockito
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    /*¿Por que usamos mockito para pruebas unitarias y no solo jUnit?
    La mayoría de las clases que trabajamos a la hora de hacer test tienen dependencias.
    Y a su vez muchos metodos delegan en otros médotos de otras clases. Lo cual lo hace dependiente de terceros.
    Al hacer test unitarios con jUnit nuestros test tambien dependen de estos métodos.
    Pero como hemos dicho siempre los test unitarios tienen que ser independientes de todas las dependencias.
    Para este caso utilizamos Mockito.
     */



    /*
    Cuatro cosas Mock a nivel básico
    //1.- Hacer Mock de clases o interfaz
    //2.- Nos permite programar un comportamiento
    //3.- Nos permite ejecutar un metodo
    //4.- Verificar
     */
    //1.- Hacer Mock de clases o interfaz

    /*
    In order to enable Mockito annotation (such as @Spy, @Mock, … ) – we need to do one of the following:

Call the method MockitoAnnotations.initMocks(this) to initialize annotated fields
Use the built-in runner @RunWith(MockitoJUnitRunner.class)
     */

    /*
        Un Mock es una implementación ficticia para una interfaz o clase en la que nosotros podemos definir la salida
        de ciertas llamadas de metodos.
        Es decir, que esos objetos mockeados estan configurados para realizar el comportamiento que deseamos en esa prueba.
        */
    //1.- Hacer Mock de Clases o Intefaces
    @Mock
    private Login.View view;

    @Mock
    private Login.Model model;

    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception{
        presenter = new LoginPresenter(view);
    }

    @Test
    public void shouldShowErrorMessageWhenUserOrPasswordIsWrongTest() throws Exception{
        //2.- Nos permite programar un comportamiento -> En este caso el usuario y contraseña
        when(view.getUserName()).thenReturn("maria");
        when(view.getPassword()).thenReturn("asdf");
        //3.- Ejecutamos un metodo, pero ahora view.getUserName, tiene el comportamiento que le hemos indicado arriba.
        presenter.validadUser(view.getUserName(), view.getPassword());
        //4.- Verificamos que la vista ejecuta el metodo error
        verify(view).error();
    }

    @Test
    public void shouldCallusuarioValidoWhenUserAndPasswordAreRightTest() throws Exception{
        //2.- Nos permite programar un comportamiento -> En este caso el usuario y contraseña
        when(view.getUserName()).thenReturn("alberto");
        when(view.getPassword()).thenReturn("1234");
        //Podemos usar junit para probar
        Assert.assertEquals("alberto", view.getUserName());
        //3.- Ejecutamos un metodo, pero ahora view.getUserName, tiene el comportamiento que le hemos indicado arriba.
        presenter.validadUser(view.getUserName(), view.getPassword());
        //4.- Verificamos que la vista ejecuta el metodo error
        verify(view).usuarioValido();
    }

    /*
    The when then patter
    thenReturn(returnValue) -> Para devolver un parametro
    thenThrow(exception) -> Para lanzar una excepción
    thenCallRealMethod() -> Para llamar un metodo real
    thenAnswer() -> Para devolver respuestas más inteligentes. O cuando hemos mockeado un metodo void y queremos que haga algo.
     */
    @Test
    public void shouldThrowingException() throws Exception{
        when(view.getUserName()).thenThrow(RuntimeException.class);
        try{
            view.getUserName();
        }catch (RuntimeException e){

        }

    }

    /*
    Testear Void Method
    Los metodos con valores de retorno son facilmente testeables. Con el metodo Assert podemos saber si nos devuelve lo
    requerido.
    Pero como podemos probar los metodos que devuelve void.
    Los metodos que devuelven void, pueden llamar a otros metodos en su interior.
    O pueden procesar valores de entrada.
    Con Mockito podemos testear estas cosas.
    Mockito nos deja confirmar si algún metodo ha sido llamado en esos objetos simulados durante nuestro test.
    Se puede hacer con assertion o no. Al final es abarcar un campo grande de test.
    Hay dos métodos de verificación
    1.- El que solo acepta el objeto mock. Podemos usarlo si solo vamos a invocarlo UNA VEZ.
    2.- El otro acepta el objeto mock y un Modo de Verificación.
        Los modos de verificación son:
        times(int wantedNumberOfInvocations)
        atLeast( int wantedNumberOfInvocations )
        atMost( int wantedNumberOfInvocations )
        calls( int wantedNumberOfInvocations )
        only( int wantedNumberOfInvocations )
        atLeastOnce()
        never()
     */

    @Test
    public void shouldCallusuarioValidoWhenUserAndPasswordAreRightDoReturnTest() throws Exception{
        doReturn("alberto").when(view).getUserName();
        Assert.assertEquals("alberto", view.getUserName());
    }


    @Test
    public void shouldCallusuarioValidoWhenUserAndPasswordAreRightTest2() throws Exception{
        //2.- Nos permite programar un comprortamiento
        when(view.getUserName()).thenReturn("alberto");
        when(view.getPassword()).thenReturn("1234");
        Assert.assertEquals("alberto", view.getUserName());
        //3.- Ejecutamos un metodo
        presenter.validadUser(view.getUserName(), view.getPassword());
        //4.- Verificar que la vista ejecuta el metodo Error
        verify(view).usuarioValido();

        verify(view, times(1)).usuarioValido();
       // verify(view, never()).usuarioValido();
        verify(view, atLeast(1)).usuarioValido();
        verify(view, atMost(7)).usuarioValido();
        //verify(view, only()).usuarioValido();

    }

    @Mock
    List<String> mockList = new ArrayList<>();

    /*
    Mockito Spy
    A veces tenemos que llamar a métodos reales de una dependencia. Y además queremos verificar las
    iteraciones de dicha dependencia. Aquí utilizamos los Espias.
    @Spy crea una envoltura alrededor de uan instancia real de dicho objetio y por lo tanto podemos llamar a la
    implementación real y verificar las interaciones del mimso.
    Parte del comportamiento de un Espia puede ser Mockeado si lo necesitamos.

     */
    @Spy
    List<String> spyList = new ArrayList<>();

    /*
    Diferencia entre Mock y Spy
    Cuando crear un Mock mokito lo hace desde la Class de un Type no de una instancia Real.
    El Mock simplemente crear una cascara de la clase, que rastrea las interaciones del mismo.
    El Espia en cambio si es una isntancia real y además rastrea la interaciones del mismo.
     */


    /*
    Al agregar un elemento a una lista Mock no agraga nada a la lista.
    Simplemente llama al método y queda registrado sin ningún otro efecto secundario.
     */
    @Test
    public void spyTest() throws Exception{
        spyList.add("one");
        spyList.add("two");

        verify(spyList).add("one");
        verify(spyList).add("two");

        Assert.assertEquals(2, spyList.size());
    }
    /*
       Por otro lado el espía se comportará de manera diferente.
       Llama a la implementación real del metodo en este caso agregar un elementeo a la lista y lo agrega de verdad.

        */
    @Test
    public void mockTest() throws Exception{
        mockList.add("one");
        mockList.add("two");

        verify(mockList).add("one");
        verify(mockList).add("two");

        Assert.assertEquals(2, spyList.size());
    }



}