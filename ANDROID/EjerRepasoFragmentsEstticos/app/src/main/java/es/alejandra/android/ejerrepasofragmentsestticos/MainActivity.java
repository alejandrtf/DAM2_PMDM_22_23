package es.alejandra.android.ejerrepasofragmentsestticos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        PrincipalFragment.OnOperacionCalculadaListener,
        View.OnClickListener {
    // VISTAS
    EditText etIncremento;
    Button btFragmentoPrincipalA, btFragmentoSumaB, btFragmentoRestaC;

    // FRAGMENTS
    SumaFragment sumaFragment;
    RestaFragment restaFragment;
    PrincipalFragment principalFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initReferences();
        setListenerToButtons();

    }

    /**
     * Método que asigna a los objetos Java las vistas XMl
     */
    public void initReferences() {
        etIncremento = findViewById(R.id.etIncremento);
        btFragmentoPrincipalA = findViewById(R.id.btFragmentA);
        btFragmentoSumaB = findViewById(R.id.btFragmentB);
        btFragmentoRestaC = findViewById(R.id.btFragmentC);
        // fragments (los necesito por los botones de los fragments
        sumaFragment = (SumaFragment) getSupportFragmentManager().findFragmentById(R.id.frSuma);
        restaFragment = (RestaFragment) getSupportFragmentManager().findFragmentById(R.id.frResta);
        principalFragment = (PrincipalFragment) getSupportFragmentManager().findFragmentById(R.id.frPrincipal);
    }


    /**
     * Método que asigna los escuchadores de clicks a los botones de la Activity
     */
    public void setListenerToButtons() {
        btFragmentoPrincipalA.setOnClickListener(this);
        btFragmentoSumaB.setOnClickListener(this);
        btFragmentoRestaC.setOnClickListener(this);
    }

    /**
     * Método que se ejecuta al pulsar el botón calcular del fragment principal
     *
     * @param resultado de la operación
     * @param operacion + si fue suma, - si fue resta
     */
    @Override
    public void onOperacionCalculada(float resultado, char operacion) {
        if (operacion == '+') {
            if (sumaFragment != null)
                sumaFragment.mostrarResultado(resultado);
            else {
                Toast.makeText(this, "Error cargando el fragment suma", Toast.LENGTH_SHORT).show();
            }
        } else {
            if (restaFragment != null)
                restaFragment.mostrarResultado(resultado);
            else
                Toast.makeText(this, "Error cargando el fragment resta", Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * Método que se ejecuta al pulsar los botones de los Fragments A, B o C
     *
     * @param view botón pulsado
     */
    @Override
    public void onClick(View view) {
        String incrementoString = etIncremento.getText().toString();
        if (TextUtils.isEmpty(incrementoString)) {
            Toast.makeText(this, "Debes introducir un incremento", Toast.LENGTH_SHORT).show();
        } else {
            switch (view.getId()) {
                case R.id.btFragmentA:
                    // Debe incrementarse el % del EditText en el Fragment principal
                    if (principalFragment != null) {
                        principalFragment.incrementarResultado(Integer.parseInt(incrementoString));
                    }
                    break;
                case R.id.btFragmentB:
                    // Debe incrementarse el % del EditText en el Fragment de la suma
                    if (sumaFragment != null) {
                        sumaFragment.incrementarResultado(Integer.parseInt(incrementoString));
                    }
                    break;
                case R.id.btFragmentC:
                    // Debe incrementarse el % del EditText en el fragment de la resta
                    if (restaFragment != null) {
                        restaFragment.incrementarResultado(Integer.parseInt(incrementoString));
                    }

            }
            etIncremento.setText("");
        }

    }
}