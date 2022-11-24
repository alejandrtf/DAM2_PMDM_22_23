package es.alejandra.android.ejemplomanejovariosradiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Este ejemplo es una calculadora básica que suma, resta, multiplica y divide
 * sólo con trabajando con 2 operandos
 */
public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    // VIEWS
    EditText etOperando1, etOperando2;
    TextView tvResultado;
    RadioGroup rgTipoOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initReferences();
        setListenersToRadioButtons();
    }


    /**
     * Método obtiene las referencias a las vistas XML
     */
    private void initReferences() {
        etOperando1 = findViewById(R.id.etNumero1);
        etOperando2 = findViewById(R.id.etNumero2);
        tvResultado = findViewById(R.id.tvResultado);
        rgTipoOperacion = findViewById(R.id.rgTipoOperacion);
    }

    /**
     * Método que asigna el escuchador al RadioGroup que contiene los RadioButtons
     */
    private void setListenersToRadioButtons() {
        rgTipoOperacion.setOnCheckedChangeListener(this);
    }

    /**
     * Método que se ejecuta cuando se elige cualquiera de los RadioButtons disponibles
     *
     * @param radioGroup     el radioGroup que contiene los RadioButtons sobre los que se ha clickado
     * @param idSeleccionado el ID del RadioButton que se ha elegido
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int idSeleccionado) {
        if(TextUtils.isEmpty(etOperando1.getText()) || TextUtils.isEmpty(etOperando2.getText())){
            // no se introdujeron números
            Toast.makeText(this, "Error: debes introducir dos números!!!", Toast.LENGTH_SHORT).show();
        }else{
            // CONVIERTO A int LOS DOS OPERANDOS
            int op1=Integer.valueOf(etOperando1.getText().toString());
            int op2=Integer.valueOf(etOperando2.getText().toString());

            // REALIZAMOS LA OPERACIÓN QUE SE HAYA ELEGIDO
            switch (idSeleccionado) {
                case R.id.rbSumar: tvResultado.setText(String.valueOf(op1+op2)); break;
                case R.id.rbRestar: tvResultado.setText(String.valueOf(op1-op2)); break;
                case R.id.rbMultiplicar:tvResultado.setText(String.valueOf(op1*op2)); break;
                case R.id.rbDividir:tvResultado.setText(String.valueOf((float)op1/op2)); break;
            }
        }

    }
}