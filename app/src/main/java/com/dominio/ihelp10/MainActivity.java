package com.dominio.ihelp10;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dominio.ihelp10.modelos.ConstantesFirebase;
import com.dominio.ihelp10.controladores.LoginControlador;
import com.dominio.ihelp10.modelos.Usuario;
import com.dominio.ihelp10.utils.ValidarCorreo;
import com.dominio.ihelp10.vistas.ClientStart;
import com.dominio.ihelp10.vistas.ExpertStart;
import com.dominio.ihelp10.vistas.ForgotPassword;
import com.dominio.ihelp10.vistas.SignIn;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;

public class MainActivity extends AppCompatActivity {


    private View text_registrarse, text_olvido_contraseña;
    private EditText et_email, et_password;
    private Button bt_login;
    private ListenerRegistration listenerRegistration;
    private String tipo;


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

        usuarioConectado();


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

    private void usuarioConectado() {
        FirebaseUser usuario= FirebaseAuth.getInstance().getCurrentUser();


        if(usuario!=null){
            obtenerDatos();
            try {
                if (tipo.equals("Cliente")){
                    startActivity(new Intent(MainActivity.this, ClientStart.class));
                    finish();
                } else {
                    startActivity(new Intent(MainActivity.this, ExpertStart.class));
                    finish();
                }
            } catch (NullPointerException | IllegalStateException e){
                e.getCause();}
        }
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

    private void obtenerDatos(){
        FirebaseUser usuarioActual = FirebaseAuth.getInstance().getCurrentUser();
        String idUsuarioActual = usuarioActual.getUid();

        DocumentReference documentReference= FirebaseFirestore.getInstance()
                .collection(ConstantesFirebase.USUARIOS)
                .document(idUsuarioActual);
        listenerRegistration = documentReference.addSnapshotListener(informacionUsuario);
    }
    private EventListener<DocumentSnapshot> informacionUsuario= new EventListener<DocumentSnapshot>() {
        @Override
        public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

            try {
                if(value!=null){
                    Usuario usuario= value.toObject(Usuario.class);

                    if(usuario!=null){

                        tipo = usuario.getTipo();

                    }
                }
            }catch (NullPointerException | IllegalStateException e){
                e.getCause();
            }
        }
    };
}
