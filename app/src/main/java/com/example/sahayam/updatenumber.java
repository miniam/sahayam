package com.example.sahayam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class updatenumber extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myref;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatenumber);
        e1=(EditText)findViewById(R.id.sample);
                e2=(EditText)findViewById(R.id.sample1);
        database=FirebaseDatabase.getInstance();

    }
    public void updatenumber(View v){
        String str=e1.getText().toString();
        String  str1=e2.getText().toString();
        Intent i=getIntent();
        final String username=i.getStringExtra("useraccount");
        myref=database.getReference().child("Accounts");
        if (str.equals(str1)) {
            myref.child(username).child("Emergency Number").setValue(str);
            Toast.makeText(this, "Updated Succesfully", Toast.LENGTH_SHORT).show();
            e1.setText("");
            e2.setText("");
        }
        else
        {
            Toast.makeText(this, "Enter correct Details", Toast.LENGTH_SHORT).show();
        }

    }
}
