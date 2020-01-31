package com.example.sahayam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }
    public void  maps(View v){

        Intent i=getIntent();
        String username=i.getStringExtra("username");
        Intent i1=new Intent(Homepage.this,MapsActivity.class);
        i1.putExtra("nameofuser",username);
        startActivity(i1);
    }
    public void Update(View v){
        Intent i=getIntent();
        String username=i.getStringExtra("username");
        Intent i2=new Intent(Homepage.this,updatenumber.class);
        i2.putExtra("useraccount",username);
        startActivity(i2);
    }
    public void hosp(View v){

        Intent i3 = new Intent(Homepage.this,appointment.class);
        startActivity(i3);

    }
}
