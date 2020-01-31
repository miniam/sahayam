package com.example.sahayam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class phone extends AppCompatActivity {

    public static final String[] countrynames={"india","pakistan"};
    public static  String phonenum;

    TextView t;

    private EditText phno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);


        Intent intent=getIntent();

        final String HOSNAME=intent.getStringExtra("hspn");
        final String DEPNAME=intent.getStringExtra("depn");
        final String DOCNAME=intent.getStringExtra("docn");



        phno=findViewById(R.id.edphno);

        findViewById(R.id.cont).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String number=phno.getText().toString().trim();

                if(number.isEmpty()||number.length()<10){

                    phno.setError("Valid number is required");
                    phno.requestFocus();
                    return;

                }

                String phoneno="+91"+number;

                Intent intent =new Intent(phone.this,verify.class);

                intent.putExtra("phonenumber",phoneno);

                phonenum=phoneno;

                intent.putExtra("hspn",HOSNAME);
                intent.putExtra("depn",DEPNAME);
                intent.putExtra("docn",DOCNAME);

                startActivity(intent);
            }
        });

    }
}
