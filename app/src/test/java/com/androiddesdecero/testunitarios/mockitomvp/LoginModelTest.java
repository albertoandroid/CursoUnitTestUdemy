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
@RunWith(MockitoJUnitRunner.class)
public class LoginModelTest {

    @Mock
    private Login.Presenter presenter;

    private LoginModel model;

    @Before
    public void setUp() throws Exception{
        model = new LoginModel(presenter);
    }

    @Test
    public void shouldSuccessWithValidUserAndPasswordTest() throws Exception{
        model.validaUser("alberto", "1234");
        verify(presenter).usuarioValido();
    }

    @Test
    public void shouldNotSuccessWithValidUserAndPasswordTest() throws Exception{
        model.validaUser("maria", "1234");
        verify(presenter).error();
    }

}