package com.androiddesdecero.testunitarios.mockitomvp;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

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
        //2.- Nos permite programar un comprortamiento
        when(view.getUserName()).thenReturn("maria");
        when(view.getPassword()).thenReturn("asdf");
        //3.- Ejecutamos un metodo
        presenter.validadUser(view.getUserName(), view.getPassword());
        //4.- Verificar que la vista ejecuta el metodo Error
        verify(view).error();
    }
}