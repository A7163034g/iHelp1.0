package com.dominio.ihelp10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    private Button bt_Recuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        //finish();

        bt_Recuperar=findViewById(R.id.bt_Recuperar);

        bt_Recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Mail enviado correctamente" , Toast.LENGTH_LONG).show();
                Intent intent =new Intent(ForgotPassword.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}