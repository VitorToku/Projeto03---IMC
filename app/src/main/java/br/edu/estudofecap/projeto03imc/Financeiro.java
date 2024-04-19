package br.edu.estudofecap.projeto03imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class Financeiro extends AppCompatActivity {
    TextInputEditText inputSalarioBruto;
    Button btnCalculosFinanceiros, btnLimpar, btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financeiro);

        inputSalarioBruto = findViewById(R.id.inputMateriaNI);
        btnCalculosFinanceiros = findViewById(R.id.btnCalcularNota);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnCalculosFinanceiros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Financeiro.this, ResultadoFinanceiro.class);
                i.putExtra("salarioBruto", Double.parseDouble(inputSalarioBruto.getText().toString()));
                startActivity(i);
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputSalarioBruto.setText("");
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}