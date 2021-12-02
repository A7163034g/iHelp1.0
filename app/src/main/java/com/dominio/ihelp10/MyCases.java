package com.dominio.ihelp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyCases extends AppCompatActivity {

    public Button bt_cerrar_sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cases);

        bt_cerrar_sesion=findViewById(R.id.bt_cerrar_sesion);

        bt_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Cerrando sesión..." , Toast.LENGTH_LONG).show();
                Intent intent =new Intent(MyCases.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}