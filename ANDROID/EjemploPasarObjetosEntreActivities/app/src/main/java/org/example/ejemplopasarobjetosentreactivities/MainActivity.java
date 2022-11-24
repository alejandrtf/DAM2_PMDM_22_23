package org.example.ejemplopasarobjetosentreactivities;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Persona miPersona;
    private Carta carta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carta = new Carta(R.drawable.ic_launcher_background, NOMBRE_CARTA.AS, 3, PALO_BARAJA.BASTOS, 3);
        miPersona = new Persona("Pepe", "Oviedo", R.drawable.ic_launcher_background, 34);

        Intent i = new Intent(this, SegundaActivity.class);
        Gson gson = new Gson();
        String miPersonaString = gson.toJson(miPersona);
        String miCartaString = gson.toJson(carta);
        i.putExtra("objeto", miPersonaString);
        i.putExtra("carta", miCartaString);
        startActivity(i);
    }


}
