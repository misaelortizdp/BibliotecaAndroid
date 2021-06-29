package com.example.biblioteca;

public class DefBD {

    public static final String nameDb = "Biblioteca";
    public static final String tabla_libros = "libro";
    public static final String col_titulo = "titulo";
    public static final String col_autor = "autor";
    public static final String col_genero = "genero";
    public static final String col_editorial = "editorial";

    public static final String create_tabla_lib = "CREATE TABLE IF NOT EXISTS" +
            DefBD.tabla_libros + "(" +
            DefBD.col_titulo + " text primary key," +
            DefBD.col_autor + " text,"+
            DefBD.col_genero + " text," +
            DefBD.col_editorial + " text" +
            ");";



}
