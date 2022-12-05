package es.alejandra.android.ejemploasynctask;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    // VIEWS
    EditText etUrl;
    Button btCargarImagen, btOtraTarea;

    // VARIABLES
    String url;
    // TAREA ASÍNCRONA DE DESCARGA
    CargarImagenDesdeUrlTask cargarImagenDesdeUrlTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initReferences();
        setListenersToButtons();


    }

    /**
     * Método obtiene las referencias de las vistas XML
     */
    private void initReferences() {
        etUrl = findViewById(R.id.etUrl);
        btCargarImagen = findViewById(R.id.btCargarImagen);
        btOtraTarea = findViewById(R.id.btOtraTarea);
    }

    /**
     * Método que asigna los escuchadores a los botones
     */
    private void setListenersToButtons() {
        btCargarImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // recuperar la url del cuadro texto
                url = etUrl.getText().toString();
                cargarImagenDesdeUrlTask=new CargarImagenDesdeUrlTask(MainActivity.this);
                cargarImagenDesdeUrlTask.execute(url);
            }
        });

        btOtraTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "HACIENDO OTRA TAREA", Toast.LENGTH_SHORT).show();
            }
        });
    }

}