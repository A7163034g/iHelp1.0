package com.dominio.ihelp10.controladores;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dominio.ihelp10.MainActivity;
import com.dominio.ihelp10.modelos.ConstantesFirebase;
import com.dominio.ihelp10.modelos.Usuario;
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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;


public class LoginControlador {

    private static ListenerRegistration listenerRegistration;
    private static String tipo;

    public static void login(MainActivity mainActivity, String email, String password) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            obtenerDatos();
                            FirebaseUser usuario= FirebaseAuth.getInstance().getCurrentUser();

                            if(usuario!=null){
                                obtenerDatos();
                                try {
                                    if (tipo.equals("Cliente")){
                                        mainActivity.startActivity(new Intent(mainActivity, ClientStart.class));
                                        mainActivity.finish();
                                    } else {
                                        mainActivity.startActivity(new Intent(mainActivity, ExpertStart.class));
                                        mainActivity.finish();
                                    }
                                } catch (NullPointerException | IllegalStateException e){
                                    e.getCause();
                                }
                            }


                        } else {
                            Toast.makeText(mainActivity, "Error al iniciar sesion", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private static void obtenerDatos(){
        FirebaseUser usuarioActual = FirebaseAuth.getInstance().getCurrentUser();
        String idUsuarioActual = usuarioActual.getUid();

        DocumentReference documentReference= FirebaseFirestore.getInstance()
                .collection(ConstantesFirebase.USUARIOS)
                .document(idUsuarioActual);
        listenerRegistration = documentReference.addSnapshotListener(informacionUsuario);
    }
    private static EventListener<DocumentSnapshot> informacionUsuario= new EventListener<DocumentSnapshot>() {
        @Override
        public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
            MainActivity mainActivity = new MainActivity();
            try {
                if(value!=null){
                    Usuario usuario= value.toObject(Usuario.class);

                    if(usuario!=null){

                        tipo = usuario.getTipo();
                        Toast.makeText(mainActivity.getApplicationContext(), tipo,Toast.LENGTH_LONG);
                        try {
                            if (tipo.equals("cliente")){
                                mainActivity.startActivity(new Intent(mainActivity, ClientStart.class));
                                mainActivity.finish();
                            } else {
                                mainActivity.startActivity(new Intent(mainActivity, ExpertStart.class));
                                mainActivity.finish();
                            }
                        } catch (NullPointerException | IllegalStateException e){
                            e.getCause();
                        }

                    }
                }
            }catch (NullPointerException | IllegalStateException e){
                e.getCause();
            }
        }
    };
}
