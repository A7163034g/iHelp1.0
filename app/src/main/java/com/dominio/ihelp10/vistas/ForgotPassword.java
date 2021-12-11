package com.dominio.ihelp10.vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dominio.ihelp10.MainActivity;
import com.dominio.ihelp10.R;
import com.dominio.ihelp10.controladores.RecuperarContraControlador;
import com.dominio.ihelp10.utils.ValidarCorreo;

public class ForgotPassword extends AppCompatActivity {

    private Button bt_Recuperar;
    private EditText et_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        bt_Recuperar=findViewById(R.id.bt_Recuperar);
        et_email= findViewById(R.id.et_email);

        bt_Recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validar()){
                    RecuperarContraControlador.recuperar(ForgotPassword.this,getEmail());
                } else {
                    Toast.makeText(ForgotPassword.this, "Email no valido, por favor verifique nuevamente" , Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private boolean validar() {
        String email= getEmail().trim();

        return ValidarCorreo.validar(email);
    }
    public String getEmail() {
        return et_email.getText().toString();
    }
}