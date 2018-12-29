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

    @Test
    public void shouldCallusuarioValidoWhenUserAndPasswordAreRightTest() throws Exception{
        //2.- Nos permite programar un comprortamiento
        when(view.getUserName()).thenReturn("alberto");
        when(view.getPassword()).thenReturn("1234");
        Assert.assertEquals("alberto", view.getUserName());
        //3.- Ejecutamos un metodo
        presenter.validadUser(view.getUserName(), view.getPassword());
        //4.- Verificar que la vista ejecuta el metodo Error
        verify(view).usuarioValido();
    }

    @Test
    public void shouldThrowingException() throws Exception{
        when(view.getUserName()).thenThrow(RuntimeException.class);
        try{
            view.getUserName();
        }catch (RuntimeException e){

        }

    }

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

    @Spy
    List<String> spyList = new ArrayList<>();

    @Test
    public void spyTest() throws Exception{
        spyList.add("one");
        spyList.add("two");

        verify(spyList).add("one");
        verify(spyList).add("two");

        Assert.assertEquals(2, spyList.size());
    }

    @Test
    public void mockTest() throws Exception{
        mockList.add("one");
        mockList.add("two");

        verify(mockList).add("one");
        verify(mockList).add("two");

        Assert.assertEquals(2, spyList.size());
    }



}