package com.dominio.ihelp10.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dominio.ihelp10.MainActivity;
import com.dominio.ihelp10.R;

public class UnassignedTickets extends AppCompatActivity {

    private Button bt_cerrar_sesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unassigned_tickets);

        bt_cerrar_sesion=findViewById(R.id.bt_cerrar_sesion);

        bt_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Cerrando sesión..." , Toast.LENGTH_LONG).show();
                Intent intent =new Intent(UnassignedTickets.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}