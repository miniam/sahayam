package com.example.sahayam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class employhome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employhome);
    }

    public void emtake(View view) {
        Intent i3 = new Intent(employhome.this,employtake.class);
        startActivity(i3);
    }

    public void emgive(View view) {
        Intent i3 = new Intent(employhome.this,employgive.class);
        startActivity(i3);
    }
}
