package com.dominio.ihelp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FrequentCases extends AppCompatActivity {

    private Button bt_cerrar_sesion;
    private Button bt_solicitar_soporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequent_cases);

        bt_cerrar_sesion=findViewById(R.id.bt_cerrar_sesion);

        bt_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Cerrando sesión..." , Toast.LENGTH_LONG).show();
                Intent intent =new Intent(FrequentCases.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bt_solicitar_soporte=findViewById(R.id.bt_solicitar_soporte);

        bt_solicitar_soporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(FrequentCases.this, CreateCase.class);
                startActivity(intent);
            }
        });




    }
}