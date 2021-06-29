package com.example.biblioteca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class LibroController {
    private BaseDatos bd;
    private Context c;
    public LibroController( Context c) {
        this.bd = new BaseDatos(c,1);
        this.c = c;
    }

    public void agregarLibro(Libro l){
        try {
            SQLiteDatabase sql = bd.getWritableDatabase();
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_titulo, l.getTitulo());
            valores.put(DefBD.col_autor, l.getAutor());
            valores.put(DefBD.col_genero, l.getGenero());
            valores.put(DefBD.col_editorial, l.getEditorial());
            long id = sql.insert(DefBD.tabla_libros, null, valores);
            //sql.execSQL("insert into " + DefBD.tabla_est + " values (" + e.getCodigo() + "," + e.getNombre() + "," + e.getPrograma() +");");
            Toast.makeText(c, "Libro registrado", Toast.LENGTH_LONG).show();
        }
        catch(Exception ex){
            Toast.makeText(c, "Error agregando Libro " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }


    public boolean buscarLibro(Libro l){
        String args[] = new String[] {l.getTitulo()};
        String[] columnas = {DefBD.col_titulo,DefBD.col_autor, DefBD.col_genero, DefBD.col_editorial};
        String col[] = new String[] {DefBD.col_titulo,DefBD.col_autor, DefBD.col_genero, DefBD.col_editorial};
        SQLiteDatabase sql = bd.getReadableDatabase();
        Cursor c = sql.query(DefBD.tabla_libros ,null,"titulo=?",args,null,null,null);
        if (c.getCount()>0){
            bd.close();
            return true;
        }
        else{
            bd.close();
            return false;
        }
    }

    public Cursor allLibros(){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            Cursor cur = sql.rawQuery("select titulo as _id , autor, genero, editorial from libro", null);
            return cur;
        }
        catch (Exception ex){
            Toast.makeText(c, "Error consulta libro " + ex.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    public void eliminarLibro(String cod){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {cod};
            sql.delete(DefBD.tabla_libros,"titulo=?",args);
            Toast.makeText(c, "Libro eliminado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error eliminar Libro " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void actualizarLibro(Libro l){
        try{
            SQLiteDatabase sql = bd.getReadableDatabase();
            String[] args = {l.getTitulo()};
            ContentValues valores = new ContentValues();
            valores.put(DefBD.col_autor, l.getAutor());
            valores.put(DefBD.col_genero, l.getGenero());
            valores.put(DefBD.col_editorial, l.getEditorial());
            sql.update(DefBD.tabla_libros,valores,"titulo=?",args);
            Toast.makeText(c, "Libro actualizado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(c, "Error actualizar libros " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }












}
