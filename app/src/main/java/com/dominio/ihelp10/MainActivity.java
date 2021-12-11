package com.dominio.ihelp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dominio.ihelp10.controladores.LoginControlador;
import com.dominio.ihelp10.controladores.RegistroControlador;
import com.dominio.ihelp10.utils.ValidarCorreo;
import com.dominio.ihelp10.vistas.ClientStart;
import com.dominio.ihelp10.vistas.ForgotPassword;
import com.dominio.ihelp10.vistas.SignIn;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private View text_registrarse, text_olvido_contraseña;
    private EditText et_email, et_password;
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
        et_email=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);
        text_registrarse=findViewById(R.id.text_registrarse);
        text_olvido_contraseña=findViewById(R.id.text_olvido_contraseña);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email= et_email.getText().toString();
                String password= et_password.getText().toString();

                if (validar()){
                    LoginControlador.login(MainActivity.this,email, password);
                } else {
                    Toast.makeText(MainActivity.this, "Ingreso de datos no validos, por favor intente nuevamente", Toast.LENGTH_LONG).show();
                }
            }
            });

            text_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);
            }
        });

        text_olvido_contraseña.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForgotPassword.class);
                startActivity(intent);
            }
        });

    }
    private boolean validar() {
        String email= getEmail().trim();
        String contrasena= getContrasena().trim();

        return ValidarCorreo.validar(email) && contrasena.length()>2;
    }

    public String getContrasena() {
        return et_password.getText().toString();
    }

    public String getEmail() {
        return et_email.getText().toString();
    }

}
