package com.example.layner.notification;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {
    private String Titulo, Texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        Intent it = getIntent();
        if(it != null){
            Bundle bundle = it.getExtras();
            if (bundle != null){
                Titulo = bundle.getString("Titulo");
                Texto = bundle.getString("Texto");

                TextView tvResultadoTit = findViewById(R.id.tvResultadoTit);
                TextView tvResultadoTex = findViewById(R.id.tvResultadoTex);

                tvResultadoTit.setText(Titulo.toString());
                tvResultadoTex.setText(Texto.toString());
            }
        }
    }
}
