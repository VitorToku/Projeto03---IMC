package br.edu.estudofecap.projeto03imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultadoImc extends AppCompatActivity {
    TextView txtPeso, txtAltura, txtImc, txtClassificacao, txtObesidade;
    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_imc);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        txtAltura = findViewById(R.id.txtAltura);
        txtPeso = findViewById(R.id.txtPeso);
        txtImc = findViewById(R.id.txtImc);
        txtClassificacao = findViewById(R.id.txtClassificacao);
        txtObesidade = findViewById(R.id.txtObesidade);

        Intent i = getIntent();
        double peso =i.getDoubleExtra("peso",0);
        double altura =i.getDoubleExtra("altura",0);

        double imc = calcularImc(peso,altura);

        preencherCampos(peso, altura,imc);
    }

    private double calcularImc(double peso, double altura){
        double imc = 0.0;

        if(altura == 0){
            return 0.0;
        }else{
            imc = peso/(altura*altura);
        }
     return imc;
    }
    private String arredondar(double valor){
        final DecimalFormat df = new DecimalFormat("0.00");
        return df.format(valor);
    }

    private void preencherCampos(double peso, double altura, double imc){
        txtAltura.setText(altura+ " m");
        txtPeso.setText(peso+ " Kg");
        txtImc.setText(arredondar(imc));

        if(imc >= 40){
            txtClassificacao.setText("Obesidade Grave");
            txtObesidade.setText("III");
        }else if(imc < 40 && imc >= 30){
            txtClassificacao.setText("Obesidade");
            txtObesidade.setText("II");
        }else if(imc < 30 && imc >= 25){
            txtClassificacao.setText("Sobrepeso");
            txtObesidade.setText("I");
        }else if(imc < 25 && imc >= 18.5){
            txtClassificacao.setText("Normal");
            txtObesidade.setText("0");
        }else if(imc < 18.5){
            txtClassificacao.setText("Magreza");
            txtObesidade.setText("0");
        }
    }
}