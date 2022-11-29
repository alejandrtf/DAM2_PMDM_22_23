package es.alejandra.android.ejemploenviosms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SmsManager sms = SmsManager.getDefault(); // using android SmsManager
        sms.sendTextMessage("+1-555-123-4567", null, "Hola que tal", null, null); // adding number and text
    }
}