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
import com.dominio.ihelp10.controladores.RegistroControlador;
import com.dominio.ihelp10.utils.ValidarCorreo;

import java.util.Locale;

public class SignIn extends AppCompatActivity {

    private Button bt_registrame;
    private EditText text_cedula, et_contrasena, text_email, text_confirmarcontrasena, et_nombre, et_tipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        bt_registrame=findViewById(R.id.bt_registrame);
        text_cedula=findViewById(R.id.text_cedula);
        et_nombre=findViewById(R.id.et_nombre);
        et_contrasena=findViewById(R.id.et_contrasena);
        text_email=findViewById(R.id.text_email);
        text_confirmarcontrasena=findViewById(R.id.text_confirmarcontrasena);
        et_tipo=findViewById(R.id.et_tipo);



        bt_registrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validar()){
                    RegistroControlador.registro(SignIn.this, getCedula(),getContrasena(),getEmail(),getNombre(),getTipo());
                    Toast.makeText(SignIn.this, "Registrado correctamente" , Toast.LENGTH_LONG).show();
                    Intent intent =new Intent(SignIn.this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(SignIn.this,"Ingreso de datos no validos, por favor intente nuevamente",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    private boolean validar(){
        String cedula= getCedula().trim();
        String email= getEmail().trim();
        String contrasena= getContrasena().trim();
        String confirmarcontrasena= getConfirmarcontrasena().trim();
        String nombre= getNombre().trim();
        String tipo= getTipo().trim().toLowerCase(Locale.ROOT);

        return ValidarCorreo.validar(email) && cedula.length() > 2 && contrasena.length() > 5 && confirmarcontrasena.equals(contrasena) && nombre.length()>2 && (tipo.equals("cliente") || tipo.equals("trabajador"));
    }

    public String getCedula() {
        return text_cedula.getText().toString();
    }
    public String getNombre() {
        return et_nombre.getText().toString();
    }

    public String getTipo() {
        return et_tipo.getText().toString();
    }

    public String getContrasena() {
        return et_contrasena.getText().toString();
    }

    public String getEmail() {
        return text_email.getText().toString();
    }

    public String getConfirmarcontrasena() {
        return text_confirmarcontrasena.getText().toString();
    }
}