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
import java.util.Objects;

public class timing extends AppCompatActivity {

    TextView tv;
    ListView lv;
    ArrayList<String> arr=new ArrayList<String>();
    private ArrayList<String> arrayList=new ArrayList<String>();
    private ArrayAdapter<String> adapter;
    private DatabaseReference reference;
    public static  String day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing);


        final Intent intent=getIntent();

        final String depid=intent.getStringExtra("depid");
        final String clcid=intent.getStringExtra("clcid");
        final String docid=intent.getStringExtra("docname");



        lv=(ListView)findViewById(R.id.timlv);


        final String strs[]={"Huddar","Divya","Raja","Yadav","Bhatted","Alka","Aggarwal","Shalini","Rajagopal", "Arun","Sujata","Meenakshi","Kamini","Gupta","Rahul","Mahanta","Manjusha","Pankaj","Narayan", "Meera","Shivani","Pramod","Shivakumar","V Rao","Jyoti","Prashanth"};

        int i;

        for(String s:strs) {
            arr.add(s);
        }


        i=arr.indexOf(docid);

        final String std=Integer.toString(i+1);



        lv=(ListView)findViewById(R.id.timlv);
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        reference= FirebaseDatabase.getInstance().getReference();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i1=new Intent(timing.this,phone.class);

                String stpp=arrayList.get(position);
                day=stpp;


                startActivity(i1);

            }
        });


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (int k = 0; k <= 192; k++) {

                    String s = Integer.toString(k);
                    String str = dataSnapshot.child(s).child("DepartmentID").getValue().toString();
                    String str1 = dataSnapshot.child(s).child("ClinicID").getValue().toString();
                    String str2 = dataSnapshot.child(s).child("DoctorID").getValue().toString();


                    if (str.equals(depid) && str1.equals(clcid)&&str2.equals(std)) {

                        String str3 = Objects.requireNonNull(dataSnapshot.child(s).child("Day").getValue()).toString();

                        if (!arrayList.contains(str3)) {
                            arrayList.add(str3);
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
