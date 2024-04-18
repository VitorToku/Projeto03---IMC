package br.edu.estudofecap.projeto03imc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {
    Button btnVoltar;
    TextInputEditText inputPeso, inputAltura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnVoltar = findViewById(R.id.btnVolta);
        inputAltura = findViewById(R.id.inputAltura);
        inputPeso = findViewById(R.id.inputPeso);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double altura = Double.valueOf(inputAltura.getText().toString());
                Double peso = Double.valueOf(inputPeso.getText().toString());
                Double imc = altura * peso;

                Intent i = new Intent();
                i.putExtra("imc", imc);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}