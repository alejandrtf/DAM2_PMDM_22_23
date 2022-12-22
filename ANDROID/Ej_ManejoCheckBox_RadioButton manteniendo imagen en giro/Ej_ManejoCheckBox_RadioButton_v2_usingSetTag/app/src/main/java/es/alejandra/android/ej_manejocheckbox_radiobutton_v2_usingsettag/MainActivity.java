package es.alejandra.android.ej_manejocheckbox_radiobutton_v2_usingsettag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // VIEWS
    ImageButton ibMortadelo, ibMafalda;
    ImageView ivImagenCentral;
    CheckBox cbFondoRojo, cbTransparente, cbActivityVerde;
    ConstraintLayout layoutActivity;
    RadioGroup rgOpcionesEscalado;

    // VARIABLES
    private Drawable fondoInicialImagenCentral, fondoInicialActivity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initReferences();

        // obtengo fondo inicial de la imagen del centro
        fondoInicialImagenCentral = ivImagenCentral.getBackground();
        // obtengo fondo inicial Activity
        fondoInicialActivity = layoutActivity.getBackground();

        setListenersToButtons();
        setListenersToCheckBoxes();
        setListenersToRadioButtons();
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("imagen_central", (Integer) ivImagenCentral.getTag());
        super.onSaveInstanceState(outState);
    }



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ivImagenCentral.setImageResource(savedInstanceState.getInt("imagen_central"));
    }





    /**
     * Método que inicializa los objetos Java con las View de la UI
     */
    private void initReferences() {
        ibMortadelo = findViewById(R.id.ibMortadelo);
        ibMafalda = findViewById(R.id.ibMafalda);
        ivImagenCentral = findViewById(R.id.imageView);
        cbFondoRojo = findViewById(R.id.cbFondoRojo);
        cbTransparente = findViewById(R.id.cbTransparente);
        cbActivityVerde = findViewById(R.id.cbActivityVerde);
        layoutActivity = findViewById(R.id.clLayoutActivity);
        rgOpcionesEscalado = findViewById(R.id.rgOpcionesEscalado);

    }

    /**
     * Método que asigna escuchadores evento clic a los botones
     */
    private void setListenersToButtons() {
        /** La solución comentada sería creando clases anónimas del escuchador
         *
         */
      /* ibMortadelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivImagenCentral.setImageDrawable(ibMortadelo.getDrawable());
            }
        });

        ibMafalda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivImagenCentral.setImageDrawable((ibMafalda.getDrawable()));
            }
        });*/

        ibMafalda.setOnClickListener(this);
        ibMortadelo.setOnClickListener(this);
    }

    /**
     * Método asigna escuchadores onCheckedChange a los CheckBoxes
     */
    private void setListenersToCheckBoxes() {
        cbFondoRojo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    ivImagenCentral.setBackgroundColor(Color.RED);
                } else {
                    ivImagenCentral.setBackground(fondoInicialImagenCentral);
                }
            }
        });

        cbTransparente.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    ivImagenCentral.setAlpha(0.5f);
                } else {
                    ivImagenCentral.setAlpha(1f);
                }
            }
        });

        cbActivityVerde.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    layoutActivity.setBackgroundColor(Color.GREEN);
                } else {
                    layoutActivity.setBackground(fondoInicialActivity);
                }
            }
        });
    }

    /**
     * Método asigna escuchadores onCheckedChange a los RadioButtons
     */
    private void setListenersToRadioButtons() {
        rgOpcionesEscalado.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idSeleccionado) {
                if (idSeleccionado == R.id.rbCentrado) {
                    ivImagenCentral.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                } else {
                    ivImagenCentral.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
            }
        });
    }


    /**
     * Mëtodo se va  a ejecutar cuando se pulse el boton de mafalda o mortadelo
     *
     * @param view representa la vista que se ha pulsado (en este caso será uno de esos dos botones)
     */
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ibMafalda) {
            ivImagenCentral.setTag(R.drawable.mafalda);
            ivImagenCentral.setImageDrawable(((ImageButton) view).getDrawable());
        } else{
            ivImagenCentral.setTag(R.drawable.mortadelo);
            ivImagenCentral.setImageDrawable(((ImageButton) view).getDrawable());
        }



    }



}
