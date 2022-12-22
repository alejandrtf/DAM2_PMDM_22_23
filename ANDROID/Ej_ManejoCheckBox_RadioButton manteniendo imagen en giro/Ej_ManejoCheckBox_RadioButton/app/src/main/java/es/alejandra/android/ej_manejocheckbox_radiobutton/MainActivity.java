package es.alejandra.android.ej_manejocheckbox_radiobutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
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
        Bitmap imagenCentralBitmap=convertirDrawableToBitmap(ivImagenCentral.getDrawable());
        outState.putParcelable("imagen_central",imagenCentralBitmap);
        super.onSaveInstanceState(outState);
    }



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ivImagenCentral.setImageBitmap(savedInstanceState.getParcelable("imagen_central"));
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

    /** Método que convierte una imagen Drawable a Bitmap
     *
     * @param drawable la imagen de tipo Drawable que se desea convertir
     * @return la imagen convertida en formato Bitmap
     */
    private Bitmap  convertirDrawableToBitmap(Drawable drawable) {
        // si la imagen es compatible con BitmapDrawable
        if(drawable instanceof BitmapDrawable){
             return ((BitmapDrawable)drawable).getBitmap();
        }

        // cuando la imagen no es compatible con BitmapDrawable, por ej: una imagen ninepatch
        // hay que crear un canvas (es como un lienzo donde se dibuja) y dibujarla en el canvas.
        // Pero para crear un canvas, se necesita darle un bitmap donde poder dibujar. Ese bitmap
        // debe tener un tamaño, que en nuestro caso, serán las dimensiones del drawable
        // DIMENSIONES DE UN DRAWABLE:
        // getIntrinsicWidth() y getIntrinsicHeight() son las dimensiones reales de la imagen jpeg, png,...
        // pero si es un color sólido, u otro tipo no BitmapDrwable, por ejemplo no las tiene y devuelve -1
        // -----
        // getBounds() devuelve un rectángulo que representa las dimensiones de una imagen que ya
        // ha sido dibujada en la pantalla, por ejemplo en un ImageView. Funciona con todo tipo
        //  de Drawable. Todo Drawable para poder dibujarse en pantalla debe tener asignados unos
        //  BOUNDS con setBounds().
        // Cuando seteamos una imagen a un ImageView el sistema operativo Android lo hace por nosotros,
        // pero si dibujamos nosostros sobre un canvas hay que hacerlo a mano:
        // drawable.setBounds(left,top,right,bottom)


        // Preguntamos por los bounds de la imagen (si los tiene) y si no, cogemos el ancho real
        // de la imagen y su alto real
       final int width = !drawable.getBounds().isEmpty() ?
                drawable.getBounds().width() : drawable.getIntrinsicWidth();

        final int height = !drawable.getBounds().isEmpty() ?
                drawable.getBounds().height() : drawable.getIntrinsicHeight();

        // Ahora comprobamos que el ancho y alto de la imagen no sean negativos (no serviría) y
        // creamos un bitmap con esas medidas y la configuración ARGB_8888.
        // A partir de ese bitmap crearemos el canvas en el que dibujaremos el drawable que queríamos convertir
        final Bitmap bitmap = Bitmap.createBitmap(width <= 0 ? 1 : width, height <= 0 ? 1 : height,
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;

    }

    /**
     * Mëtodo se va  a ejecutar cuando se pulse el boton de mafalda o mortadelo
     *
     * @param view representa la vista que se ha pulsado (en este caso será uno de esos dos botones)
     */
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ibMafalda) {
            ivImagenCentral.setImageDrawable(((ImageButton) view).getDrawable());
        } else
            ivImagenCentral.setImageDrawable(((ImageButton) view).getDrawable());


    }



}
