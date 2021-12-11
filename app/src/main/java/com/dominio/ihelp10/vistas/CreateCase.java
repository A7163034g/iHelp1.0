package com.dominio.ihelp10.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.dominio.ihelp10.MainActivity;
import com.dominio.ihelp10.R;

public class CreateCase extends AppCompatActivity {

    private Button bt_crear_caso;
    private Button bt_cerrar_sesion;
    private Button bt_inicio;
    private Spinner spinner3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_case);

      //  String [] categoria = {"Internet","Televisiòn"};
      //  ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoria);
       // spinner3.setAdapter(adapter);

        bt_crear_caso=findViewById(R.id.bt_crear_caso);

        bt_crear_caso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(CreateCase.this, MyCases.class);
                startActivity(intent);
                finish();
            }
        });

        bt_cerrar_sesion=findViewById(R.id.bt_cerrar_sesion);

        bt_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Cerrando sesión..." , Toast.LENGTH_LONG).show();
                Intent intent =new Intent(CreateCase.this, MainActivity.class);
                startActivity(intent);
            }
        });

        bt_inicio=findViewById(R.id.bt_inicio);

        bt_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(CreateCase.this, ClientStart.class);
                startActivity(intent);
            }
        });
    }
}