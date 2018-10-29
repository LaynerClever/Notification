package com.example.layner.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void gerarNotificacao(View view){

        //INICIALIZANDO OS COMPONENTES DE TEXTO
        EditText edtTitulo = findViewById(R.id.edtTitulo);
        String Titulo = edtTitulo.getText().toString();

        EditText edtTexto = findViewById(R.id.edtTexto);
        String Texto = edtTexto.getText().toString();

        //CRIANDO INTENT PARA CHAMAR A SEGUNDA TELA
        Intent intent = new Intent(MainActivity.this, SegundaTela.class);

        //CRIANDO BUNDLE PARA TRANSFERIR OS DADOS PARA A SEGUNDA TELA
        Bundle bundle = new Bundle();
        bundle.putString("Titulo",Titulo);
        bundle.putString("Texto",Texto);

        intent.putExtras(bundle);

        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,
                (int) System.currentTimeMillis(), intent, 0);


        //CRIANDO NOTIFICAÇÃO SIMPLES (CURTA)
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.alert)
                .setContentTitle(Titulo)
                .setContentText(Texto)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
