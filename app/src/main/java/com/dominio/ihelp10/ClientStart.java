package com.dominio.ihelp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ClientStart extends AppCompatActivity {

    private Button bt_cerrar_sesion;
    private Button bt_mis_casos;
    private Button bt_crear_caso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_start);



        bt_cerrar_sesion=findViewById(R.id.bt_cerrar_sesion);

        bt_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Cerrando sesión..." , Toast.LENGTH_LONG).show();
                Intent intent =new Intent(ClientStart.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bt_mis_casos=findViewById(R.id.bt_mis_casos);

        bt_mis_casos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(getApplicationContext(), "Cerrando sesión..." , Toast.LENGTH_LONG).show();
                Intent intent =new Intent(ClientStart.this, MyCases.class);
                startActivity(intent);
                //finish();
            }
        });

        bt_crear_caso=findViewById(R.id.bt_crear_caso);

        bt_crear_caso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(ClientStart.this, FrequentCases.class);
                startActivity(intent);
            }
        });
    }
}