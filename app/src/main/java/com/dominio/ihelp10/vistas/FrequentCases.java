package com.dominio.ihelp10.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.dominio.ihelp10.MainActivity;
import com.dominio.ihelp10.R;

public class FrequentCases extends AppCompatActivity {

    private Button bt_cerrar_sesion;
    private Button bt_solicitar_soporte;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequent_cases);

        bt_cerrar_sesion=findViewById(R.id.bt_cerrar_sesion);
        bt_solicitar_soporte=findViewById(R.id.bt_solicitar_soporte);
        spinner2=findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.categorias, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter);

        bt_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Cerrando sesión..." , Toast.LENGTH_LONG).show();
                Intent intent =new Intent(FrequentCases.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



        bt_solicitar_soporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(FrequentCases.this, CreateCase.class);
                startActivity(intent);
            }
        });




    }
}