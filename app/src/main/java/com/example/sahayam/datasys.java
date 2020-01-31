package com.example.sahayam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class datasys extends AppCompatActivity {

    private DatabaseReference reference;

    private ListView lst;
    private TextView  tv;

    private ArrayList<String> arrayList=new ArrayList<>();
    private ArrayAdapter<String> adapter;
    public static  String department;
    ProgressBar pg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datasys);

        lst=(ListView)findViewById(R.id.listviewdb);
        pg=(ProgressBar)findViewById(R.id.progressBar);
        pg.setVisibility(View.VISIBLE);

        reference= FirebaseDatabase.getInstance().getReference();

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i1=new Intent(datasys.this,clinic.class);

                String st=Integer.toString(position+1);

                String wer=arrayList.get(position);

                i1.putExtra("Depid",st);
                startActivity(i1);
                department=wer;


            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(int i=200;i<=206;i++) {

                    String s = Integer.toString(i);

                    String str = dataSnapshot.child(s).child("Department").getValue().toString();
                    arrayList.add(str);

                    if(i==206)
                        pg.setVisibility(View.INVISIBLE);

                }

                lst.setAdapter(adapter);

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });






    }
}
