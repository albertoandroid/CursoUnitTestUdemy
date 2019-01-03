package com.androiddesdecero.testunitarios.mockitomvp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Created by albertopalomarrobledo on 29/12/18.
 */
//Para Correr el Test con Mockito
@RunWith(MockitoJUnitRunner.class)
public class LoginModelTest {

    /*
    Cuatro cosas Mock a nivel básico
    //1.- Hacer Mock de clases o interfaz
    //2.- Nos permite programar un comportamiento
    //3.- Nos permite ejecutar un metodo
    //4.- Verificar
     */
    //1.- Hacer Mock de clases o interfaz


    /*
    Cuando creamos un Mock
    Mocktio nos deuvle empty values
    null for objetcts
    0 for numbers
    false for boolean
    empty list for listas o collection
     */
    @Mock
    private Login.Presenter presenter;

    private LoginModel model;

    @Before
    public void setUp() throws Exception{
        model = new LoginModel(presenter);
    }

    @Test
    public void shouldSuccessWithValidUserAndPasswordTest() throws Exception{
        //3.- Nos permite ejecutar un metodo
        model.validaUser("alberto", "1234");
        //4.- Verificamos si han realizado las llamadas correctas (en este caso si se ha llamado a usuarioValido() en el presenter)
        //al ejecutar el metodo validaUser del modelo.
        //Es decir estamos enviado el usuario y password correcto, por lo tanto tiene que llamar a este metodo.
        verify(presenter).usuarioValido();
    }

    @Test
    public void shouldNotSuccessWithValidUserAndPasswordTest() throws Exception{
        //3.- Nos permite ejecutar un metodo
        model.validaUser("maria", "1234");
        //4.- Verificamos si han realizado las llamadas correctas (en este caso si se ha llamado a usuarioValido() en el presenter)
        //al ejecutar el metodo validaUser del modelo.
        //Es decir estamos enviado el usuario y password correcto, por lo tanto tiene que llamar a este metodo.
        verify(presenter).error();
    }

}