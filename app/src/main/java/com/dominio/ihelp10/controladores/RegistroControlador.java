package com.dominio.ihelp10.controladores;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.dominio.ihelp10.MainActivity;
import com.dominio.ihelp10.modelos.ConstantesFirebase;
import com.dominio.ihelp10.modelos.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

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
                    .document(id)
                    .set(usuario,SetOptions.merge())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Intent intent= new Intent(context, MainActivity.class );
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                context.startActivity(intent);
                            } else {
                                Toast.makeText(context,"Error al guardar datos del usuario en base de datos",Toast.LENGTH_LONG);
                            }
                        }
                        });
        } catch (NullPointerException e){
            e.getCause();
        }
    }
}
