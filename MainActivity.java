package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textResultado;
    private EditText editPeso;
    private EditText editAltura;
    private RadioButton radioimc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.Resultado);
        editPeso = findViewById(R.id.Peso);
        editAltura = findViewById(R.id.Altura);
        radioimc = findViewById(R.id.imc);

        Button buttonCalcular = findViewById(R.id.button);
        buttonCalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calcularImc(v);
            }
        });


    }

    public void calcularImc(View V) {
        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double resultado = peso / (altura * altura);
        double IMC = resultado;


        String classificacao;
        if (resultado < 19) {
            classificacao = "Abaixo do peso";
        } else if (resultado < 25) {
            classificacao = "Peso Normal";
        } else if (resultado < 30) {
            classificacao = "Sobrepeso";
        } else if (resultado < 40) {
            classificacao = "Obesidade tipo I";
        } else {
            classificacao = "Obesidade tipo II";
        }

        if (radioimc.isChecked()) {
            textResultado.setText(String.format("IMC: %.2f ", IMC, classificacao));
        } else {
            textResultado.setText(classificacao);
        }
    }
}









