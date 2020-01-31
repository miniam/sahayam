package com.example.sahayam;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Agribusiness extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agribusiness);
    }
   public void writePosts(View view) {
        Intent intent=new Intent(Agribusiness.this,WritePosts.class);
        startActivity(intent);
    }
   public  void readPosts(View view) {
        Intent intent=new Intent(Agribusiness.this,ReadPosts.class);
        startActivity(intent);
    }
}
