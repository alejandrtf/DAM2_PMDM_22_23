package org.example.ejemplopasarobjetosentreactivities;

import android.graphics.drawable.Drawable;

public class Persona {
    private String nombre;
    private String direccion;
    private int idFoto;
    private int edad;

    public Persona(String nombre, String direccion, int idFoto, int edad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.idFoto = idFoto;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        String datos=this.nombre+"-"+this.direccion+"-"+this.edad+"-"+this.idFoto;
        return datos;
    }
}
