package es.alejandra.android.ejemploserviciosnotificacionesreceptoresanuncios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MostrarFicheroActivity extends AppCompatActivity {
    private String[] datosFichero;
    // UI
    private TextView tvTextoFichero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_fichero);
        initReferences();
        // recojo el texto del fichero del intent
        if (getIntent().hasExtra(MainActivity.ReceptorAvisosServicio.EXTRA_KEY_DATOS_FICHERO)) {
            datosFichero = getIntent().getStringArrayExtra(MainActivity.ReceptorAvisosServicio.EXTRA_KEY_DATOS_FICHERO);
        }


        if (datosFichero != null && datosFichero.length > 0) {
            // hay datos
            for (String linea : datosFichero) {
                //extraigo cada palabra de la línea (el nombre alumno, su asignatura,...)
                String[] lineaTroceada = linea.split(",");
                // añado al TextView la línea formateada con espacios entre palabras
                tvTextoFichero.append(String.format("%-16s", lineaTroceada[0]) +
                        String.format("%-28s", lineaTroceada[1]) +
                        String.format("%-15s", lineaTroceada[2]) +
                        String.format("%10s", lineaTroceada[3]) + "\n");
                // %-10s --> el "-" indica que rellene por la derecha con espacios blancos
            }
        }
    }

    /**
     * Método que obtiene las referencias a las vistas XML
     */
    private void initReferences() {
        tvTextoFichero = findViewById(R.id.tvContenidoFichero);
    }
}