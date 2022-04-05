package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtUbicacion, txtTelefono;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUbicacion = findViewById(R.id.txtUbicacion);
        txtTelefono = findViewById(R.id.txtTelefono);
        btnEnviar = findViewById(R.id.btnEnviar);

        final DeveloperDB developerDB=new DeveloperDB(getApplicationContext());

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                developerDB.agregarRegistros(txtUbicacion.getText().toString(),txtTelefono.getText().toString());
                Toast.makeText(getApplicationContext(),"a",Toast.LENGTH_SHORT).show();
            }
        });
    }
}