package es.alejandra.android.ejemplointentimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void abrirURL(View v){
        EditText etUrl = (EditText) findViewById(R.id.editTextURL);
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(etUrl.getText().toString()));
        startActivity(i);
    }

    public void llamar(View v){
        EditText etTlf = (EditText) findViewById(R.id.editTextTel);
        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+etTlf.getText().toString()));
        startActivity(i);
    }

    public void marcar(View v){
        EditText etTlf = (EditText) findViewById(R.id.editTextTel);
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+etTlf.getText().toString()));
        startActivity(i);
    }

    public void foto(View v){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 1);
    }

    public void email(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "asunto");
        intent.putExtra(Intent.EXTRA_TEXT, "texto del correo");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {" micorreo@servidor.com" });
        intent.putExtra(Intent.EXTRA_CC, new String[] {"pepe@boro.com", "lolailo@lolailo.com"});
        startActivity(intent);
    }

    public void maps(View v){
        EditText etLong = (EditText) findViewById(R.id.editTextLong);
        EditText etLat = (EditText) findViewById(R.id.editTextLat);
        Intent i = new Intent(Intent.ACTION_VIEW);
      //  i.setData(Uri.parse("geo:"+etLat.getText().toString() + "," + etLong.getText().toString()));
        i.setData(Uri.parse("geo:47.6,-122.3"));
        startActivity(i);
    }

    public void street(View v){
        EditText etLong = (EditText) findViewById(R.id.editTextLong);
        EditText etLat = (EditText) findViewById(R.id.editTextLat);
        Intent i = new Intent(Intent.ACTION_VIEW);
        String lat = etLat.getText().toString();
        String lon = etLong.getText().toString();
      //  i.setData(Uri.parse("google.streetview:cbll="+lat+","+lon));
        i.setData(Uri.parse("google.streetview:cbll=47.6,-122.3"));
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            Bundle b = data.getExtras();
            Bitmap bmp = (Bitmap) b.get("data");
            ImageView iv = (ImageView)findViewById(R.id.imageView1);
            iv.setImageBitmap(bmp);
        }
    }


}
