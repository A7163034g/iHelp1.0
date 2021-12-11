package com.dominio.ihelp10;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
/*
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseUser usuario= FirebaseAuth.getInstance().getCurrentUser();
        String currentUserId= usuario.getUid();

        if(usuario==null){
            iniciarNuevaActividad(MainActivity.class);
        }else if(usuario.){
            iniciarNuevaActividad(MainActivity.class);
        } else {

        }
    }

    private void iniciarNuevaActividad(Class clase) {
        startActivity(new Intent(this, clase));
        finish();
    }
} */
