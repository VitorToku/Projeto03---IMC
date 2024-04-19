package br.edu.estudofecap.projeto03imc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultadoNotas extends AppCompatActivity {
    TextView txtTeste;
    RecyclerView recyclerNotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_notas);
        recyclerNotas = findViewById(R.id.recyclerNotas);

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("Bundle");
        ArrayList<Materia> lista = (ArrayList<Materia>) args.getSerializable("Lista");
        Materia materia = lista.get(4);
        String teste = "Matéria: " + materia.getNomeMateria() + "NI: " + materia.getNi() + "PI: " + materia.getPi() + "PO: " + materia.getPo();
        Toast.makeText(this, teste, Toast.LENGTH_SHORT).show();
        AdapterNotas adapter = new AdapterNotas(lista);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerNotas.setLayoutManager(layoutManager);
        recyclerNotas.setHasFixedSize(true);

        recyclerNotas.setAdapter(adapter);
    }
}