package com.example.sahayam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
   EditText e1,e2;
 FirebaseDatabase database;
 DatabaseReference myref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.username);
        e2=(EditText)findViewById(R.id.password);
        database=FirebaseDatabase.getInstance();

    }
    public void entered(View c){
        final String names=e1.getText().toString();
       final String pass=e2.getText().toString();
        myref=database.getReference().child("Accounts");
    if(!names.isEmpty() && !pass.isEmpty()) {
        myref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(names).exists()) {
                    String orgpassword = dataSnapshot.child(names).child("Password").getValue().toString();
                    if (orgpassword.equals(pass)) {
                        Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, Homepage.class);
                        i.putExtra("username",names);
                        startActivity(i);
                        e1.setText("");
                        e2.setText("");

                    } else {
                        Toast.makeText(MainActivity.this, "Invalid Details", Toast.LENGTH_SHORT).show();
                        e1.setText("");
                        e2.setText("");
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Account Do not Exists", Toast.LENGTH_SHORT).show();
                    e1.setText("");
                    e2.setText("");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    else
    {
        Toast.makeText(this, "Enter Complete Details", Toast.LENGTH_SHORT).show();
    }
    }
    public void entered1(View v){
        Intent i1=new Intent(MainActivity.this,Signup.class);
        startActivity(i1);
    }
}
