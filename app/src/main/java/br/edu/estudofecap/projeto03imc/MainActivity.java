package br.edu.estudofecap.projeto03imc;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnMudar;
    TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMudar = findViewById(R.id.btnTrocar);
        txtResultado = findViewById(R.id.txtResultado);
        btnMudar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamarInput();
            }
        });
    }

    private void chamarInput(){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        chamarSegundaTela.launch(intent);
    }

    ActivityResultLauncher<Intent> chamarSegundaTela = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();
                        Double imc = data.getDoubleExtra("imc",0.0);
                        txtResultado.setText(imc+"");
                    }

                }
            }
    );
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo vida", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo vida", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo vida", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo vida", "onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo vida", "onDestroy");
    }
}