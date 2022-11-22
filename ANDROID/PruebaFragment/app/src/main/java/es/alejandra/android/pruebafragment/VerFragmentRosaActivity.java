package es.alejandra.android.pruebafragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class VerFragmentRosaActivity extends AppCompatActivity implements RosaFragment.OnBotonContarPulsadoListener {
    TextView tvNumeroLetra;
    RosaFragment rosaFragment;
    String palabra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_fragment_rosa);
        // recojo la palabra que viene del MainActivity
        palabra = getIntent().getStringExtra("PALABRA");
        //rosaFragment= (RosaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentRosa);
        rosaFragment = RosaFragment.newInstance(palabra);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentRosa, rosaFragment);
        ft.commit();
        fm.executePendingTransactions();

           //rosaFragment.mostrarTexto(palabra);
    }


    /**
     * Método que se ejecuta al pulsar el botón CONTAR LETRAS en teléfonos con un panel sólo
     *
     * @param numLetras el número de letras de la palabra
     */
    @Override
    public void onBotonContarPulsado(int numLetras) {
        tvNumeroLetra = findViewById(R.id.tvNumLetras);
        tvNumeroLetra.setText(String.valueOf(numLetras));
    }


}