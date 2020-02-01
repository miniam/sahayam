package com.example.sahayam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class hosbutton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosbutton);
    }
    public void mhappo(View v){

        Intent i1 = new Intent(hosbutton.this,appointment.class);
        startActivity(i1);

    }
    public void mhsearch(View v) {
        String addressString = "hospital ";
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("geo")
                .path("0,0")
                .appendQueryParameter("q", addressString);
        Uri addressUri = builder.build();

        // COMPLETED (7) Replace the Toast with a call to showMap, passing in the Uri from the previous step
        showMap(addressUri);
    }
    private void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void mhtele(View v) {
        Intent i3= new Intent(hosbutton.this,hostele.class);
        startActivity(i3);

    }
    public void mhambu(View v){
        Intent i=new Intent(hosbutton.this,ambulance.class);
        startActivity(i);
    }
}
