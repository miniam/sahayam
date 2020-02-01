package com.example.sahayam;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class employgive extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText ad,ph,wn;
    Spinner cat;
    FirebaseDatabase database;
    DatabaseReference myref123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employgive);
        database = FirebaseDatabase.getInstance();


        Spinner spinner = findViewById(R.id.spincat);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        wn=(EditText)findViewById(R.id.workerno);
        ad =(EditText)findViewById(R.id.workplace);
        ph = (EditText)findViewById(R.id.ownerphone);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Spinner spinner = findViewById(R.id.spincat);
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void empsub(View v) {
        Spinner spinner = findViewById(R.id.spincat);
        String number=wn.getText().toString();
        String place=ad.getText().toString();
        String phone=ph.getText().toString();
        String id1=spinner.getSelectedItem().toString();
        myref123=database.getReference().child(id1);
        myref123.child("workerno").setValue(number);
        myref123.child("workplace").setValue(place);
        myref123.child("ownerPhone").setValue(phone);
        Toast.makeText(this, "Details Submitted", Toast.LENGTH_SHORT).show();


    }
}

