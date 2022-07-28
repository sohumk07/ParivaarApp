package com.example.parivaarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.grpc.Compressor;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PresetData extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText mFullName,mEmail,mPassword,mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;
    FirebaseFirestore fStore;
    String userID;
    private Button menubtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preset_data);



        mFullName   = findViewById(R.id.name_of_clinic);
        mEmail      = findViewById(R.id.associated_doctor);
        mPassword   = findViewById(R.id.medical_attendant);
        mPhone      = findViewById(R.id.driver);
        mRegisterBtn= findViewById(R.id.btnSignUp);
        menubtn = findViewById(R.id.gotomenu);
        // mLoginBtn   = findViewById(R.id.createText);



        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        // progressBar = findViewById(R.id.progressBar);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),PresetData.class));
            finish();
        }

        menubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PresetData.this,Menu.class);
                startActivity(intent);



            }
        });





        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                final String clinicname = mFullName.getText().toString();
                final String doctor = mEmail.getText().toString().trim();
                final String medicalattendant = mPassword.getText().toString().trim();
                final String driver = mPhone.getText().toString().trim();


                if(TextUtils.isEmpty(clinicname)){
                    mFullName.setError("Name is Required.");
                    return;
                }

                if(TextUtils.isEmpty(doctor)){
                    mEmail.setError("Doctor is Required.");
                    return;
                }

                if(TextUtils.isEmpty(medicalattendant)){
                    mPassword.setError("Medical Attendant is Required.");
                    return;
                }

                if(TextUtils.isEmpty(driver)){
                    mPhone.setError("Driver is Required.");
                    return;
                }






                Map<String, Object> Data = new HashMap<>();
                // Data.put("clinicName", mFullName.getText().toString());
                Data.put("doctorName", mEmail.getText().toString().trim());
                Data.put("attendantName", mPassword.getText().toString().trim());
                Data.put("driverName", mPhone.getText().toString().trim());



                //documents and collections
                db.collection("Preset Data").document()
                        .set(Data)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                                Toast.makeText(PresetData.this, "Preset Data Uploaded to Database", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                                Toast.makeText(PresetData.this, "Error Uploading Preset Data to Database", Toast.LENGTH_SHORT).show();
                            }
                        });














            }
        });











    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {        getMenuInflater().inflate(R.menu.main, menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.Menu:
                startActivity(new Intent(PresetData.this, Menu.class));
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}

