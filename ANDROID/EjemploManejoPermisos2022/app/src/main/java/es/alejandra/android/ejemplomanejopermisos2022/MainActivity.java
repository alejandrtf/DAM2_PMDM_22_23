package es.alejandra.android.ejemplomanejopermisos2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    // CONSTANTS
    private static final int SOLICITUD_PERMISO_CALL_PHONE = 0;
    // VIEWS
    EditText etPhoneNumber;
    Button btLlamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initReferences();
        setListenersToButtons();
    }

    /**
     * Método que inicializa las referencias XML
     */
    private void initReferences() {
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        btLlamar = findViewById(R.id.btLlamar);
    }

    /**
     * Método que asigna los escuchadores a los botones
     */
    private void setListenersToButtons() {
        btLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etPhoneNumber.getText().length() != 0) {
                    // hay algún número escrito
                    llamarPorTelefono(etPhoneNumber.getText().toString());
                } else {
                    etPhoneNumber.setError("Introduce un nº de teléfono válido");
                }
            }
        });
    }

    /**
     * Método que realiza la llamada de teléfono al nº que se pasa por parámetro
     *
     * @param numeroTelefono el nº de teléfono al que hay que llamar en formato String
     */
    private void llamarPorTelefono(String numeroTelefono) {
        // COMPRUEBO SI TENGO PERMISO
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            // permiso concedido
            realizarLlamada(numeroTelefono);
        } else {
            // permiso no concedido
            solicitarPermiso(Manifest.permission.CALL_PHONE, "Sin el permiso" +
                            " realizar llamadas de teléfono no puedo realizar llamadas de teléfono",
                    SOLICITUD_PERMISO_CALL_PHONE, this);
            // donde SOLICITUD_PERMISO_CALL_PHONE es una constante definida en mi app que identifica
            // esta petición de permiso de forma única. Porque puede haber más solicitudes de permiso
            // diferentes.
        }
    }


    /**
     * Método que solicita un permiso al usuario
     *
     * @param permiso       permiso solicitado
     * @param justificacion el por qué necesitamos ese permiso
     * @param requestCode   código de solicitud de permiso que identifica esta solicitud
     * @param activity      activity que recogerá la respuesta
     */
    public static void solicitarPermiso(final String permiso, String justificacion, final int requestCode, final Activity activity) {
        // Mostrar una explicación de por qué necesito este permiso???
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permiso)) {
            new AlertDialog.Builder(activity)
                    .setTitle("Solicitud de permiso")
                    .setMessage(justificacion)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ActivityCompat.requestPermissions(activity, new String[]{permiso}, requestCode);
                        }
                    })
                    .show();
        } else {
            //pedir permiso
            ActivityCompat.requestPermissions(activity, new String[]{permiso}, requestCode);
        }
    }


    /**
     * Método que realiza la llamada al número de teléfono que se le pasa
     *
     * @param numeroTelefono el nº de teléfono al que se va a llamar en formato String
     */
    private void realizarLlamada(String numeroTelefono) {
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:" + numeroTelefono));
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        }

    }

    /**
     * Método que se ejecuta cada vez que el usuario acepta/rechaza un permiso
     *
     * @param requestCode  petición de permiso a la que se responde. Suele ser una constante definida en la app
     * @param permissions  permiso aceptado/rechazado
     * @param grantResults resultado de la concesión (granted or not)
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case SOLICITUD_PERMISO_CALL_PHONE: {
                // Si la petición se canceló, el array grantResults está vacío
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permiso fue concedido
                    realizarLlamada(etPhoneNumber.getText().toString());
                } else {
                    // permiso denegado, se debería desactivar la funcionalidad que depende de
                    // este permiso.
                    Toast.makeText(this, "PERMISO DENEGADO:Sin el permiso, no puedo realizar la acción", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

}
