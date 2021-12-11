package com.dominio.ihelp10.controladores;

import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.dominio.ihelp10.MainActivity;
import com.dominio.ihelp10.vistas.ClientStart;
import com.dominio.ihelp10.vistas.ExpertStart;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginControlador {
    public static void login(MainActivity mainActivity, String email, String password) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            FirebaseUser usuarioActual = FirebaseAuth.getInstance().getCurrentUser();
                            String idUsuarioActual = usuarioActual.getUid();

                            DatabaseReference baseDeDatos = FirebaseDatabase.getInstance().getReference().child(ConstantesFirebase.USUARIOS).child(idUsuarioActual);

                            baseDeDatos.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    String tipo= snapshot.child("tipo").getValue().toString();
                                    if (tipo.equals("cliente")){
                                        Intent intentcliente = new Intent(mainActivity,ClientStart.class);
                                        mainActivity.startActivity(intentcliente);
                                        mainActivity.finish();
                                    } else {
                                        Intent intentTecnico = new Intent(mainActivity, ExpertStart.class);
                                        mainActivity.startActivity(intentTecnico);
                                        mainActivity.finish();
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });


                            mainActivity.startActivity(new Intent(mainActivity, ClientStart.class));
                            mainActivity.finish();

                        } else {
                            Toast.makeText(mainActivity, "Error al iniciar sesion", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
