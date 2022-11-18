package es.alejandra.android.ejlistafutbolconfragmentsestaticos.modelo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

import es.alejandra.android.ejlistafutbolconfragmentsestaticos.R;

public  class Equipos {
    private static Context context;
    private static ArrayList<Equipo> listaEquipos;

    public static ArrayList<Equipo> getListaEquipos(){
        return listaEquipos;
    }

    public static void setContext(Context context2){
        context=context2;
    }


    /**
     * Método que coge los datos del array de recursos xml y rellena la lista de equipos
     * con esos datos.
     */
    public static void cargarDatos() {
        listaEquipos=new ArrayList<>();
        String[] nombres = context.getResources().getStringArray(R.array.nombre_equipo);
        int[] puntos = context.getResources().getIntArray(R.array.puntos_equipo);

        TypedArray objetos = context.getResources().obtainTypedArray(R.array.escudo_equipo);
        Drawable[] imagenes = new Drawable[objetos.length()];
        for (int i = 0; i < objetos.length(); i++) {
            imagenes[i] = objetos.getDrawable(i);
        }

        for (int i = 0; i < nombres.length; i++) {
            listaEquipos.add(new Equipo(nombres[i], imagenes[i], puntos[i]));
        }
    }
}
