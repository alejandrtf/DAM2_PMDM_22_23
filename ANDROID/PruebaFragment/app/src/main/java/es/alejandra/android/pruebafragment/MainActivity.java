package es.alejandra.android.pruebafragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GrisFragment.OnInvertirPulsadoListener,
        RosaFragment.OnBotonContarPulsadoListener {

    RosaFragment rosaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    /**
     * Método que se ejecuta al pulsar el botón INVERTIR en el fragment gris
     *
     * @param palabra palabra invertida
     */
    @Override
    public void onInvertirPulsado(String palabra) {
        rosaFragment = (RosaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentRosa);
        if (rosaFragment != null) {
            // estoy en multipanel o existen los 2 fragments
            rosaFragment.mostrarTexto(palabra);
        } else {
            // estoy en modo single panel o sólo está el fragment gris
            Intent iVerFragmentRosaActivity = new Intent(this, VerFragmentRosaActivity.class);
            iVerFragmentRosaActivity.putExtra("PALABRA", palabra);
            startActivity(iVerFragmentRosaActivity);
        }

    }


    /**
     * Método que se ejecuta al pulsar el botón CONTAR LETRAS del fragment rosa
     *
     * @param numLetras es el nº de letras de la palabra escrita
     */
    @Override
    public void onBotonContarPulsado(int numLetras) {
        TextView tvNumeroLetras = findViewById(R.id.tvNumLetras);
        if (tvNumeroLetras != null) {
            // está en el MainActivity
            tvNumeroLetras.setText(String.valueOf(numLetras));
        }


    }


}