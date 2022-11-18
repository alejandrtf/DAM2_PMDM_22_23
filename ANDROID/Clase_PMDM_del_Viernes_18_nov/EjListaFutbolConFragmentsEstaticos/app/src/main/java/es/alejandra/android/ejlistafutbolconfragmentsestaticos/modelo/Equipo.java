package es.alejandra.android.ejlistafutbolconfragmentsestaticos.modelo;

import android.graphics.drawable.Drawable;

public class Equipo {
    private String nombreEquipo;
    private Drawable imagenEscudo;
    private int puntos;

    //CONSTRUCTOR
    public Equipo(String nombreEquipo, Drawable imagenEscudo, int puntos) throws IllegalArgumentException {
        if (nombreEquipo == null || nombreEquipo.isEmpty()) {
            throw new IllegalArgumentException("ERROR: Nombre del equipo vacío. Obligatorio un nombre.");

        } else if (imagenEscudo == null) {
            throw new IllegalArgumentException("ERROR: Equipo sin foto en el escudo. Marque la casilla 'Sin foto'" +
                    "si no desea foto.");
        } else {
            this.nombreEquipo = nombreEquipo;
            this.imagenEscudo = imagenEscudo;
            this.puntos = puntos;
        }
    }

    //GETTERS AND SETTERS
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Drawable getImagenEscudo() {
        return imagenEscudo;
    }

    public void setImagenEscudo(Drawable imagenEscudo) {
        this.imagenEscudo = imagenEscudo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
