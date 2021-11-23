package com.dominio.ihelp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private View text_registrarse;
    private View text_olvido_contraseña;
    private Button bt_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep (1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt_login=findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this, ClientStart.class);
                startActivity(intent);

            }
        });

/*
        bt_login=findViewById(R.id.bt_login);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this, ExpertStart.class);
                startActivity(intent);
            }
        });
*/
        text_registrarse=findViewById(R.id.text_registrarse);

        text_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Reistro" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, SingIn.class);
                startActivity(intent);

            }
        });

        text_olvido_contraseña=findViewById(R.id.text_olvido_contraseña);

        text_olvido_contraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Olvido su contraseña" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ForgotPassword.class);
                startActivity(intent);
            }
        });




    }
}