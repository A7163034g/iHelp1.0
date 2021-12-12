package com.dominio.ihelp10.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dominio.ihelp10.MainActivity;
import com.dominio.ihelp10.R;

public class ExpertStart extends AppCompatActivity {

    private Button bt_cerrar_sesion;
    private Button bt_mis_tickets;
    private Button bt_tickets_sin_asignar;
    private Button bt_tickets_resueltos;
    private EditText nombre_del_cliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_start);

        bt_cerrar_sesion=findViewById(R.id.bt_cerrar_sesion);
        nombre_del_cliente=findViewById(R.id.nombre_del_cliente);

        bt_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Cerrando sesión..." , Toast.LENGTH_LONG).show();
                Intent intent =new Intent(ExpertStart.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bt_mis_tickets=findViewById(R.id.bt_mis_tickets);

        bt_mis_tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(ExpertStart.this, MyTickets.class);
                startActivity(intent);


            }
        });

        bt_tickets_sin_asignar=findViewById(R.id.bt_tickets_sin_asignar);

        bt_tickets_sin_asignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(ExpertStart.this, UnassignedTickets.class);
                startActivity(intent);


            }
        });

        bt_tickets_resueltos=findViewById(R.id.bt_tickets_resueltos);

        bt_tickets_resueltos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(ExpertStart.this, TicketsClosed.class);
                startActivity(intent);

            }
        });
    }
}