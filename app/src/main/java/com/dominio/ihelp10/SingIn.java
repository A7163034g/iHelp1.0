package com.dominio.ihelp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SingIn extends AppCompatActivity {

    private Button bt_registrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        //finish();

        bt_registrame=findViewById(R.id.bt_registrame);

        bt_registrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Registrado correctamente" , Toast.LENGTH_LONG).show();
                Intent intent =new Intent(SingIn.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }
}