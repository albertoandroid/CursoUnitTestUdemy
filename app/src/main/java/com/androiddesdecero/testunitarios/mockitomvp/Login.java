package com.androiddesdecero.testunitarios.mockitomvp;

/**
 * Created by albertopalomarrobledo on 28/12/18.
 */

public interface Login {

    interface View{
        void usuarioValido();
        void error();
        String getUserName();
        String getPassword();
    }

    interface Presenter{
        void validadUser(String user, String password);
        void usuarioValido();
        void error();
    }

    interface Model{
        void validaUser(String user, String password);
    }
}
