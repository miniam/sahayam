package com.example.sahayam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class appointment extends AppCompatActivity {
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        b3 = (Button)findViewById(R.id.button3);


    }

    public void appoi(View view) {
        Intent i3 = new Intent(appointment.this,datasys.class);
        startActivity(i3);
    }
}
