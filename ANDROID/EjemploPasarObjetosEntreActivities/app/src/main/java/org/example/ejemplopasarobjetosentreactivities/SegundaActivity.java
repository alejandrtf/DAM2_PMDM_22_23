package org.example.ejemplopasarobjetosentreactivities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;



import com.google.gson.Gson;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        //recojo intent
        String personaString=getIntent().getStringExtra("objeto");
        String cartaString=getIntent().getStringExtra("carta");
        Gson gson=new Gson();
        Persona persona=gson.fromJson(personaString,Persona.class);
        Carta carta=gson.fromJson(cartaString,Carta.class);
        Toast.makeText(this, persona.toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this,carta.toString(),Toast.LENGTH_SHORT).show();




    }
}
