package br.edu.estudofecap.projeto03imc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ResultadoNotas extends AppCompatActivity {
    RecyclerView recyclerNotas;
    Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_notas);
        recyclerNotas = findViewById(R.id.recyclerNotas);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        ArrayList<String> listaNomes = intent.getStringArrayListExtra("listaNomes");
        List<Materia> listaMaterias = new ArrayList<>();

        for(String nome: listaNomes){
            double NI = intent.getDoubleExtra("NI" + nome, 0.0);
            double PI = intent.getDoubleExtra("PI" + nome, 0.0);
            double PO = intent.getDoubleExtra("PO" + nome, 0.0);
            Materia materia = new Materia(nome,NI,PI,PO);
            listaMaterias.add(materia);
        }

        AdapterNotas adapter = new AdapterNotas(listaMaterias);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerNotas.setLayoutManager(layoutManager);
        recyclerNotas.setHasFixedSize(true);

        recyclerNotas.setAdapter(adapter);
    }
}