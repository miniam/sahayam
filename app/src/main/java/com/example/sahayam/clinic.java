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

public class clinic extends AppCompatActivity {

    private ListView lv;
    private TextView tv;
    private DatabaseReference reference;
    private ArrayList<String> arrayList=new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    public static  String clinicname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic);


        Intent intent=getIntent();

        final String stre=intent.getStringExtra("Depid");


        lv=(ListView)findViewById(R.id.clclv);
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        reference= FirebaseDatabase.getInstance().getReference();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i1=new Intent(clinic.this,doct.class);

                String st=Integer.toString(position+1);

                i1.putExtra("clcid",st);
                i1.putExtra("depid",stre);
                String clcea=arrayList.get(position);
                clinicname=clcea;


                startActivity(i1);


            }
        });


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {




                for(int i=0;i<=192;i++) {

                    String s = Integer.toString(i);

                    String str = dataSnapshot.child(s).child("DepartmentID").getValue().toString();


                    if(str.equals(stre)) {

                        String str1=dataSnapshot.child(s).child("ClinicName").getValue().toString();

                        if(!arrayList.contains(str1)) {
                            arrayList.add(str1);
                        }

                    }

                }

                adapter.notifyDataSetChanged();

            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        lv.setAdapter(adapter);



    }


}
