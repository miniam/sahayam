package com.example.sahayam;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
class Blog {

    public String title;
    public String subject;

    public Blog() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Blog(String title, String subject) {
        this.subject=subject;
        this.title=title;
    }

}
public class WritePosts extends AppCompatActivity {
    private DatabaseReference mDatabase;
EditText titleBox;
    EditText subjectBox;
    Button postButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writepost);
        titleBox=(EditText)findViewById(R.id.gettitle);
        subjectBox=(EditText)findViewById(R.id.getsubject);
        postButton=(Button)findViewById(R.id.postbutton);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName="siddhu";
                String title=titleBox.getText().toString();
                String subject=subjectBox.getText().toString();
                writeNewBlog(userName,title,subject);
            }
        });
    }

    private void writeNewBlog(String userName, String title, String subject) {
        Blog blog = new Blog(title, subject);
        mDatabase.child("users").child(userName).setValue(blog);
        System.out.println("done");
    }
}
