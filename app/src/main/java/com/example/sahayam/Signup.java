package com.example.sahayam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signup extends AppCompatActivity {
EditText t1,t2,t3,t4;
FirebaseDatabase database;
DatabaseReference myref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        t1=(EditText)findViewById(R.id.n1);
        t2=(EditText)findViewById(R.id.p1);
        t3=(EditText)findViewById(R.id.p2);
        t4=(EditText)findViewById(R.id.eme);
        database=FirebaseDatabase.getInstance();

    }
    public void create(View v){
        myref=database.getReference().child("Accounts");
        final String name=t1.getText().toString();
        final String password=t2.getText().toString();
        String cpassword=t3.getText().toString();
        final String mobile=t4.getText().toString();
        if(password.equals(cpassword) && !name.isEmpty() && !mobile.isEmpty()) {
            myref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child(name).exists()) {
                        Toast.makeText(Signup.this, "User Already Exists", Toast.LENGTH_LONG).show();
                    } else {
                        myref.child(name).child("Username").setValue(name);
                        myref.child(name).child("Password").setValue(password);
                        myref.child(name).child("Emergency Number").setValue(mobile);
                        Toast.makeText(Signup.this,"Created Succesfully",Toast.LENGTH_LONG).show();
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        else
        {
            Toast.makeText(Signup.this,"Enter Valid Details",Toast.LENGTH_LONG).show();
        }
    }
}
