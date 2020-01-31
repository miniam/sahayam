package com.example.sahayam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.sahayam.clinic.clinicname;
import static com.example.sahayam.datasys.department;
import static com.example.sahayam.doct.doctor;
import static com.example.sahayam.phone.phonenum;
import static com.example.sahayam.timing.day;

public class Sms extends AppCompatActivity {
    Button send,paym;
    TextView t1,t2,t3;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        Intent intent=getIntent();

        final String depn=intent.getStringExtra("depname");

        paym=(Button)findViewById(R.id.pay);

        send=findViewById(R.id.send);
        t1=findViewById(R.id.tv1);
        t2=findViewById(R.id.tv2);
        t3=findViewById(R.id.tv3);

        t1.setText(department);
        t2.setText(clinicname);
        t3.setText(doctor);

        paym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1=new Intent(Sms.this, Homepage.class);
                startActivity(i1);

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Construct data
                    String apiKey = "apikey=" + "JjBq5iJHd7g-ylpKmbpNHH7KK2WKoEO9msS0ywp5KY";
                    String message = "&message=" + "CONFIRMED Appointment at All India Institute of Ayurveda(AIIA), for Next"+day+" with Dr."+doctor+"  "+clinicname+"  "+department+" Department ";
                    String sender = "&sender=" + "TXTLCL";
                    String numbers = "&numbers=" + phonenum;

                    // Send data
                    HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
                    String data = apiKey + numbers + message + sender;
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                    conn.getOutputStream().write(data.getBytes("UTF-8"));
                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    final StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        Toast.makeText(Sms.this,line.toString(), Toast.LENGTH_SHORT).show();
                    }
                    rd.close();


                } catch (Exception e) {
                    Toast.makeText(Sms.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }


        });
        StrictMode.ThreadPolicy st=new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(st);


    }
}
