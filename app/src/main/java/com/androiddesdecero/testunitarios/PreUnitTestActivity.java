package com.androiddesdecero.testunitarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androiddesdecero.testunitarios.calculadora.CalculadoraPreUnitTest;

public class PreUnitTestActivity extends AppCompatActivity {

    private int resultado;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_unit_test);

        resultado = CalculadoraPreUnitTest.sumar(10,20);


        tvResultado = findViewById(R.id.tvResultado);
        tvResultado.setText(""+resultado);

        Log.d("TAG1", "Resultado metodo suma: " +resultado);
        if(resultado == 30){
            Log.d("TAG1", "Resultado OK: " + resultado);
        }else{
            Log.d("TAG1", "Resultado NOK: " + resultado);
        }
    }

}
