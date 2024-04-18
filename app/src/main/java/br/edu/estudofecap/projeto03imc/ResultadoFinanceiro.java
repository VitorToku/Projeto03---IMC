package br.edu.estudofecap.projeto03imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ResultadoFinanceiro extends AppCompatActivity {
    TextView txtInss, txtFgts, txtSalarioLiquido,txtSalarioBruto;
    Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_financeiro);

        txtInss = findViewById(R.id.txtInss);
        txtFgts = findViewById(R.id.txtFgts);
        txtSalarioLiquido = findViewById(R.id.txtSalarioLiquido);
        txtSalarioBruto = findViewById(R.id.txtSalarioBruto);

        Intent i = getIntent();
        double salarioBruto = i.getDoubleExtra("salarioBruto", 0.0);
        double inss = calcularInss(salarioBruto);
        double fgts = calcularFgts(salarioBruto);

        txtSalarioBruto.setText("R$ " + arredondar(salarioBruto));
        txtInss.setText("R$ " + arredondar(inss));
        txtFgts.setText("R$ " + arredondar(fgts));
        txtSalarioLiquido.setText("R$ " + arredondar(salarioBruto-inss-fgts));
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    private String arredondar(double salario){
        final DecimalFormat df = new DecimalFormat("0.00");
        return df.format(salario);
    }
    private double calcularInss(double salarioBruto){
        double[] faixaSalarial = {1412.00, 2666.68,4000.03,7786.02};
        double[] aliquota =     {0.075, 0.09, 0.12,0.14};
        double inss = 0.0;
        double taxa = 0.0;

        int faixa = verificarFaixaSalarial(faixaSalarial,salarioBruto);

            for(int i=0; i <= faixa; i++){

                if(i == faixa && faixa != faixaSalarial.length && i != 0){
                    taxa = (salarioBruto - faixaSalarial[faixa - 1]) * aliquota[i];
                    inss += taxa;
                }
                else if(i == faixa && faixa == faixaSalarial.length){

                }
                else if(i == 0 && faixa == 0){
                    inss += salarioBruto * aliquota[faixa];

                }else if(i == 0 && faixa != 0){
                    taxa = faixaSalarial[i] * aliquota[i];
                    inss += taxa;
                }else{
                    taxa = (faixaSalarial[i] - faixaSalarial[i-1]) * aliquota[i];
                    inss += taxa;
                }
        }

        return inss;
    }
    private double calcularFgts(double salarioBruto){
        double fgts = salarioBruto*0.08;
        return fgts;
    }
    private int verificarFaixaSalarial(double[] faixaSalarial, double salario){
        int faixa = -1;

        if(salario < faixaSalarial[0]){
            Log.i("faixa", "retornei 0");
            return 0;

        }
        if(salario > faixaSalarial[faixaSalarial.length-1]){
            Log.i("faixa", "retornei 4");
            return faixaSalarial.length;
        }

        for(int i = 0;i < faixaSalarial.length;i++){
            if(salario > faixaSalarial[i]){
                faixa = i;

            }
        }
        if(salario > faixaSalarial[faixa] ){
            faixa++;
        }
        Log.i("faixa", "retornei " + faixa);
        return faixa;
    }
}