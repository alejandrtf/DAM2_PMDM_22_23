package org.example.ejemplopasarobjetosentreactivities;



public class Carta {
    private int valor; //valor para el juego. Depende del juego que sea.
    private int numOrdenPalo; //número de orden que ocupa la carta dentro de su palo
    private PALO_BARAJA palo;
    private NOMBRE_CARTA nombre;
    private int idImagen;
    private boolean mostrar;

    //CONSTRUCTOR
    public Carta(int idImagen, NOMBRE_CARTA nombre, int numOrdenPalo, PALO_BARAJA palo, int valor) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.numOrdenPalo = numOrdenPalo;
        this.palo = palo;
        this.valor = valor;
        this.mostrar=false;
    }

    //GETTERS AND SETTERS
    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public NOMBRE_CARTA getNombre() {
        return nombre;
    }

    public void setNombre(NOMBRE_CARTA nombre) {
        this.nombre = nombre;
    }

    public int getNumOrdenPalo() {
        return numOrdenPalo;
    }

    public void setNumOrdenPalo(int numOrdenPalo) {
        this.numOrdenPalo = numOrdenPalo;
    }

    public PALO_BARAJA getPalo() {
        return palo;
    }

    public void setPalo(PALO_BARAJA palo) {
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "idImagen=" + idImagen +
                ", valor=" + valor +
                ", numOrdenPalo=" + numOrdenPalo +
                ", palo=" + palo +
                ", nombre=" + nombre +
                '}';
    }
}

