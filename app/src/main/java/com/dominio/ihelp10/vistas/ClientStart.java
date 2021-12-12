package com.dominio.ihelp10.vistas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dominio.ihelp10.MainActivity;
import com.dominio.ihelp10.R;
import com.dominio.ihelp10.modelos.ConstantesFirebase;
import com.dominio.ihelp10.modelos.Usuario;
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

import org.w3c.dom.Document;

public class ClientStart extends AppCompatActivity {

    private Button bt_cerrar_sesion,bt_crear_caso,bt_mis_casos;
    private TextView  nombre_del_cliente;
    private ListenerRegistration listenerRegistration;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_start);



        bt_cerrar_sesion=findViewById(R.id.bt_cerrar_sesion);
        nombre_del_cliente=findViewById(R.id.nombre_del_cliente);
        obtenerDatos();

        bt_cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarSesion();
            }
        });

        bt_mis_casos=findViewById(R.id.bt_mis_casos);

        bt_mis_casos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(ClientStart.this, MyCases.class);
                startActivity(intent);
            }
        });

        bt_crear_caso=findViewById(R.id.bt_crear_caso);

        bt_crear_caso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(ClientStart.this, FrequentCases.class);
                startActivity(intent);
            }
        });
    }

    private void cerrarSesion() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this, MainActivity.class));
        finish();
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

                        String nombre= usuario.getNombre();

                        nombre_del_cliente.setText(nombre);
                    }
                }
            }catch (NullPointerException | IllegalStateException e){
                e.getCause();
            }
        }
    };
}