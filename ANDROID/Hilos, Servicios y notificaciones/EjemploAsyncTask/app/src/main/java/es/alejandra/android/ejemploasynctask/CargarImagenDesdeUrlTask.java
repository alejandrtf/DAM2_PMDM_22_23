package es.alejandra.android.ejemploasynctask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CargarImagenDesdeUrlTask extends AsyncTask <String,Integer, Bitmap> {
    ProgressBar barraProgreso;
    private Activity activity;
    ImageView ivImagen;

    public CargarImagenDesdeUrlTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // configuramos la barra de progreso
        barraProgreso=activity.findViewById(R.id.pbBarraProgreso);
        barraProgreso.setVisibility(View.VISIBLE);
        barraProgreso.setProgress(0);
        barraProgreso.setMax(100);
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        URL imagenUrl = null;
        HttpURLConnection conn = null;
        Bitmap imagen=null;
        try {
            imagenUrl = new URL(urls[0]);
            conn = (HttpURLConnection) imagenUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            // Este código es para controlar el tamaño de la imagen y que
            // no desborde la memoria
            //2 indica 1/2 del tamaño original
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2; // el factor de escala a minimizar la
            // imagen, siempre es potencia de 2

            //simulo la carga en la barra de progreso
            //Para hacerlo real, debería leero en bytes como un fichero
            // normal e ir
            //calculando cuantos bytes se iban leyendo y hacer porcentaje
            //calculando cuantos bytes se iban leyendo y hacer porcentaje
            for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                }
                publishProgress(10);
            }
            //obtiene el bitmap con las opciones indicadas, directamente de la conexión http mediante un
            //inputStream
             imagen = BitmapFactory.decodeStream(conn.getInputStream(), null, options);
        } catch (MalformedURLException e) {
            Log.d("CARGARIMAGEN_APP","ERROR: URL mal formada");
        } catch (IOException e) {
            Log.d("CARGARIMAGEN_APP","ERROR: de entrada y/o salida en la conexión");
        }
        return imagen;
    }

    @Override
    protected void onPostExecute(Bitmap imagen) {
        super.onPostExecute(imagen);

        //asignamos la imagen al ImageView
        ivImagen=activity.findViewById(R.id.ivImagen);
        ivImagen.setImageBitmap(imagen);
    }

    @Override
    protected void onProgressUpdate(Integer... incremento) {
        super.onProgressUpdate(incremento);
        barraProgreso.incrementProgressBy(incremento[0]); //avanza de 10 en 10

    }
}
