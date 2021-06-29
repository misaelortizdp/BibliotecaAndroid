package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Libro l;
    LibroController lc;
    EditText titulo, autor, genero, editorial;
    Button guardar, listado, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titulo = findViewById(R.id.edttitulo);
        autor = findViewById(R.id.edtautor);
        genero = findViewById(R.id.edtgenero);
        editorial = findViewById(R.id.edteditorial);
        guardar = findViewById(R.id.btnguardar);
        cancelar = findViewById(R.id.btncancelar);
        listado = findViewById(R.id.btnlistado);

        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
        listado.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnguardar: //agregarLibro
                if(TextUtils.isEmpty(titulo.getText().toString()) || TextUtils.isEmpty(autor.getText().toString()) ||
                        TextUtils.isEmpty(genero.getText().toString()) || TextUtils.isEmpty(editorial.getText().toString()) ){
                    Toast.makeText(this,"Los datos no pueden ser vacíos", Toast.LENGTH_LONG).show();
                }
                else{
                    l = new Libro(titulo.getText().toString(),autor.getText().toString(),
                            genero.getText().toString(), editorial.getText().toString());
                    if (lc.buscarLibro(l)){
                        Toast.makeText(this,"Titulo ya existe", Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(this,"lo voy a agregar", Toast.LENGTH_LONG).show();
                        lc.agregarLibro(l);
                    }
                }
                break;
            case R.id.btnlistado:
                Intent i = new Intent(this, ListadoActivity.class);
                startActivity(i);
                break;


        }



    }
}