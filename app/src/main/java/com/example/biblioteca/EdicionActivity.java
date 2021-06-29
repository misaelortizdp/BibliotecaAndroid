package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EdicionActivity extends AppCompatActivity {

    EditText titulo, autor, genero, editorial;
    Button actualizar, eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);

        Intent i = getIntent();

        String titu = i.getStringExtra("titulo");
        String aut = i.getStringExtra("autor");
        String gen = i.getStringExtra("genero");
        String edt = i.getStringExtra("editorial");

        titulo = findViewById(R.id.edttit);
        autor = findViewById(R.id.edtaut);
        genero = findViewById(R.id.edtgen);
        editorial = findViewById(R.id.edtedt);
        actualizar = findViewById(R.id.btnact);
        eliminar = findViewById(R.id.btnelim);

        titulo.setText(titu);
        titulo.setEnabled(false);
        autor.setText(aut);
        genero.setText(gen);
        editorial.setText(edt);

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LibroController lc = new LibroController(getApplication());
                lc.eliminarLibro(titulo.getText().toString());
                Intent i = new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(i);
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Libro l = new Libro(titulo.getText().toString(),autor.getText().toString(),genero.getText().toString(),editorial.getText().toString() );
                LibroController lc = new LibroController(getApplication());
                lc.actualizarLibro(l);
                Intent i = new Intent(getApplicationContext(),ListadoActivity.class);
                startActivity(i);
            }
        });


    }
}