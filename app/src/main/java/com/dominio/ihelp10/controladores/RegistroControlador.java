package com.dominio.ihelp10.controladores;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.dominio.ihelp10.modelos.Usuario;
import com.dominio.ihelp10.vistas.SignIn;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegistroControlador {
    public static void registro(Context context, String cedula, String contrasena, String email, String nombre,String tipo) {

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,contrasena)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            guardarusuario(context,nombre, cedula, email,tipo);
                        } else {
                            Toast.makeText(context,"error al autenticar en base de datos",Toast.LENGTH_LONG);
                        }
                    }
                });
    }

    private static void guardarusuario(Context context, String nombre, String cedula, String email, String tipo) {
        try {
            FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

            String id= firebaseUser.getUid();
            long tiempoRegistro=firebaseUser.getMetadata().getCreationTimestamp();

            Usuario usuario= new Usuario(id, nombre, cedula, email, tiempoRegistro, tipo);

            FirebaseFirestore.getInstance()
                    .collection(ConstantesFirebase.USUARIOS)
                    .

        }catch (NullPointerException e){
            e.getCause();
        }
    }
}
