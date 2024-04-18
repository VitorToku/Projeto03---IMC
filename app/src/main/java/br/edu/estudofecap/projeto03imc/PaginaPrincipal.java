package br.edu.estudofecap.projeto03imc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PaginaPrincipal extends AppCompatActivity {
    Button btnFinanceiro, btnEducacao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);

        btnFinanceiro = findViewById(R.id.btnFinanceiro);
        btnEducacao = findViewById(R.id.btnEducacao);
        btnFinanceiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PaginaPrincipal.this, Financeiro.class);
                startActivity(i);
            }
        });

        btnEducacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PaginaPrincipal.this, Educacao.class);
                startActivity(i);
            }
        });

    }


}
