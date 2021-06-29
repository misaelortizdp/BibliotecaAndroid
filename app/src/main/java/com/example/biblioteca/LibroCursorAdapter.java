package com.example.biblioteca;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class LibroCursorAdapter extends CursorAdapter {
    public LibroCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fila_libro,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tit = view.findViewById(R.id.txttitulo);
        TextView aut = view.findViewById(R.id.txtautor);
        TextView gen = view.findViewById(R.id.txtgenero);
        TextView edit = view.findViewById(R.id.txteditorial);
        String titulo = cursor.getString(0);
        String autor = cursor.getString(1);
        String genero = cursor.getString(2);
        String editorial = cursor.getString(3);
        tit.setText(titulo);
        aut.setText(autor);
        gen.setText(genero);
        edit.setText(editorial);
    }
}
