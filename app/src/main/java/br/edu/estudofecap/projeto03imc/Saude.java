package br.edu.estudofecap.projeto03imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Saude extends AppCompatActivity {
    Button btnCalcular, btnVoltar, btnLimpar;
    TextInputEditText inputPeso, inputAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnLimpar = findViewById(R.id.btnLimpar);
        inputAltura = findViewById(R.id.inputAltura);
        inputPeso = findViewById(R.id.inputPeso);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputPeso.getText().toString().equals("")){
                    Toast.makeText(Saude.this, "Preencha o peso", Toast.LENGTH_SHORT).show();
                }else if(inputAltura.getText().toString().equals("")){
                    Toast.makeText(Saude.this, "Preencha a altura", Toast.LENGTH_SHORT).show();
                }else{
                    double peso = Double.parseDouble(inputPeso.getText().toString());
                    double altura = Double.parseDouble(inputAltura.getText().toString());

                    if(peso == 0 ){
                        Toast.makeText(Saude.this, "Preencha o peso", Toast.LENGTH_SHORT).show();
                    }else if(altura == 0){
                        Toast.makeText(Saude.this, "Preencha a altura", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent i = new Intent(Saude.this, ResultadoImc.class);
                        i.putExtra("peso", peso);
                        i.putExtra("altura", altura);
                        startActivity(i);
                    }
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void limpar(){
        inputAltura.setText("");
        inputPeso.setText("");
    }
}