package com.example.sahayam;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class verify extends AppCompatActivity {

    private String verificationId;
    private FirebaseAuth mAuth;
    private EditText code1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        mAuth=FirebaseAuth.getInstance();
        code1=findViewById(R.id.code);

        String phonenumber=getIntent().getStringExtra("phonenumber");
        verification(phonenumber);
        findViewById(R.id.verifybt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String code=code1.getText().toString().trim();

                verifycode(code);
                /*Intent intent=new Intent(getApplicationContext(),profile2.class);
                startActivity(intent);*/

            }
        });




    }

    private void verifycode(String code){

        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationId,code);

        signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {

        mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                try{
                    if(task.isSuccessful()) {
                        Toast.makeText(verify.this, "verification successful", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(verify.this,upi.class);
                        startActivity(intent);
                    }
                }catch(Exception e)
                {
                    Toast.makeText(verify.this,e.toString(),Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    private void verification(String number)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(number,30, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD,mCallBack);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verificationId=s;


        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            String code=phoneAuthCredential.getSmsCode();

            if(code!=null)
            {
                verifycode(code);
            }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

            Toast.makeText(verify.this,e.getMessage(),Toast.LENGTH_LONG).show();

        }
    };


}