package br.edu.estudofecap.projeto03imc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Educacao extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btnLimpar, btnCalcular, btnVoltar;
    List<Materia> listaDeMaterias = new ArrayList();
    String[] materias = {
            "Programação para Dispositivos Móveis",
            "Análise Descritiva de Dados",
            "Business English",
            "Programação Orientada a Objetos",
            "Projeto Interdisciplinar"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educacao);

        recyclerView = findViewById(R.id.recyclerMaterias);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
        criarLista();

        AdapterMaterias adapterMaterias = new AdapterMaterias(listaDeMaterias);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapterMaterias);
    }

    private void calcular(){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof AdapterMaterias){
            AdapterMaterias meuAdapter = (AdapterMaterias) adapter;
            List<Materia> lista = meuAdapter.getListaMaterias();
            Intent i = new Intent(Educacao.this, ResultadoNotas.class);
            Bundle args = new Bundle();
            ArrayList<String> nomes = new ArrayList<>();

            for(Materia materia: lista){
                i.putExtra( "NI" + materia.getNomeMateria(), materia.getNi());
                i.putExtra( "PI" + materia.getNomeMateria(), materia.getPi());
                i.putExtra( "PO" + materia.getNomeMateria(), materia.getPo());
                nomes.add(materia.getNomeMateria());
            }
            i.putStringArrayListExtra("listaNomes", nomes);

            startActivity(i);
        }

    }

    private void criarLista(){
        for(String titulo:materias){
            Materia materia = new Materia(titulo,0.0,0.0,0.0);
            listaDeMaterias.add(materia);
        }
    }

    private void limpar(){
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter instanceof AdapterMaterias){
            AdapterMaterias meuAdapter = (AdapterMaterias) adapter;
            meuAdapter.limparDados();
        }
    }


}