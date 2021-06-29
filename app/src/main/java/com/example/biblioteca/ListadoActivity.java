package com.example.biblioteca;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListadoActivity extends AppCompatActivity {

    ListView listado;
    LibroController lc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        listado = findViewById(R.id.lstlistado);
        lc = new LibroController(this);
        Cursor c = lc.allLibros();
        LibroCursorAdapter lcursor = new LibroCursorAdapter(this,c,false);
        listado.setAdapter(lcursor);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView titulo = view.findViewById(R.id.txttitulo);
                TextView autor = view.findViewById(R.id.txtautor);
                TextView genero = view.findViewById(R.id.txtgenero);
                TextView editorial = view.findViewById(R.id.txteditorial);
                Toast.makeText(getApplicationContext(),titulo.getText().toString() + "," + autor.getText().toString()
                        + "," + genero.getText().toString()+ "," + editorial.getText().toString(),Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), EdicionActivity.class);
                i.putExtra("titulo", titulo.getText().toString());
                i.putExtra("autor", autor.getText().toString());
                i.putExtra("genero", genero.getText().toString());
                i.putExtra("editorial", editorial.getText().toString());
                startActivity(i);
            }
        });
    }



}
