package com.example.sahayam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class doct extends AppCompatActivity {

    ListView lv;
    TextView tv;

    private DatabaseReference reference;
    private ArrayList<String> arrayList=new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    public static  String doctor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doct);

        Intent intent=getIntent();

        final String depid=intent.getStringExtra("depid");
        final String clcid=intent.getStringExtra("clcid");



        lv=(ListView)findViewById(R.id.doclv);
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        reference= FirebaseDatabase.getInstance().getReference();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i1=new Intent(doct.this,timing.class);

                String st=arrayList.get(position);

                doctor=st;

                i1.putExtra("clcid",clcid);
                i1.putExtra("depid",depid);
                i1.putExtra("docname",st);

                startActivity(i1);


            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for(int i=0;i<=192;i++) {

                    String s = Integer.toString(i);

                    String str = dataSnapshot.child(s).child("DepartmentID").getValue().toString();

                    String str1=dataSnapshot.child(s).child("ClinicID").getValue().toString();


                    if(str.equals(depid)&&str1.equals(clcid)) {



                        String str2=dataSnapshot.child(s).child("DoctorName").getValue().toString();

                        if(!arrayList.contains(str2)) {
                            arrayList.add(str2);
                        }

                    }




                    lv.setAdapter(adapter);
                }

                adapter.notifyDataSetChanged();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}