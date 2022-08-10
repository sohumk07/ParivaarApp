package com.example.parivaarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AdapterView.OnItemSelectedListener;
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

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.SetOptions;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;



public class DiagnoseIllness extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button button;
    public static final String TAG = "TAG";
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    private Button upload;
    private int numberofcases = 0;

    EditText doctorsnotefullname, doctorsnote, doctorsadvice, medicinesused, referral, followup, clinicname, districtname, date;
    String[] users = { "Fever", "Skin", "Chronic Disease", "Bp/Sugar", "Eye", "Other" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose_illness);






        upload =findViewById(R.id.dn_upload);

        districtname = findViewById(R.id.district_name);
        date = findViewById(R.id.date);
        clinicname = findViewById(R.id.clinic_name);
        doctorsnotefullname = findViewById(R.id.dn_full_name2);
        doctorsadvice = findViewById(R.id.dn_doctors_advice);
        medicinesused = findViewById(R.id.dn_medicines_uses);
        followup = findViewById(R.id.dn_follow_up);
        referral = findViewById(R.id.dn_referral);
        upload = findViewById(R.id.dn_upload);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),DailyActivation.class));
            finish();
        }

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {







                final String doctorsnotefullname1 = doctorsnotefullname.getText().toString().trim();
                final String doctorsadvice1 = doctorsadvice.getText().toString().trim();
                final String medicinesused1 = medicinesused.getText().toString().trim();
                final String followup1 = followup.getText().toString().trim();
                final String referral1 = referral.getText().toString().trim();








                if(TextUtils.isEmpty(clinicname.getText().toString())){
                    clinicname.setError("Cannot Be Empty");
                    Toast.makeText(DiagnoseIllness.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(doctorsnotefullname1)){
                    doctorsnotefullname.setError("Cannot Be Empty");
                    Toast.makeText(DiagnoseIllness.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();

                    return;
                }
                if(TextUtils.isEmpty(doctorsadvice1)){
                    doctorsadvice.setError("Cannot Be Empty");
                    Toast.makeText(DiagnoseIllness.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();

                    return;
                }
                if(TextUtils.isEmpty(medicinesused1)){
                    medicinesused.setError("Cannot Be Empty");
                    Toast.makeText(DiagnoseIllness.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();

                    return;
                }
                if(TextUtils.isEmpty(followup1)){
                    followup.setError("Cannot Be Empty");
                    Toast.makeText(DiagnoseIllness.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();

                    return;
                }
                if(TextUtils.isEmpty(referral1)){
                    referral.setError("Cannot Be Empty");
                    Toast.makeText(DiagnoseIllness.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();

                    return;
                }

                Map<String, Object> DiagnoseIllness = new HashMap<>();
                //DiagnoseIllness.put("name", doctorsnotefullname.getText().toString().trim());
                // DiagnoseIllness.put("doctorNote", doctorsnote.getText().toString().trim());
                DiagnoseIllness.put("doctorAdvice", doctorsadvice.getText().toString().trim());
                DiagnoseIllness.put("medicinesUsed", medicinesused.getText().toString().trim());
                DiagnoseIllness.put("followUpNeeded", followup.getText().toString().trim());
                DiagnoseIllness.put("needOfReferral", referral.getText().toString().trim());

                //Map<String, Object> Data = new HashMap<>();


                //DiagnoseIllness.put("Doctor's Note", Data);



                //documents and collections
                db.collection("Patient Registration and-or Doctor's Notes").document(doctorsnotefullname.getText().toString().trim().toUpperCase())
                        .set(DiagnoseIllness, SetOptions.merge())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                                Toast.makeText(DiagnoseIllness.this, "Medical Assesment Uploaded to Database", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                                Toast.makeText(DiagnoseIllness.this, "Error Uploading Medical Assesment to Database", Toast.LENGTH_SHORT).show();
                            }
                        });






                //new collection
                Map<String, Object> DiagnoseIllnessData = new HashMap<>();
                DiagnoseIllnessData.put("Number Of Cases", numberofcases += 1);

                FirebaseFirestore db = FirebaseFirestore.getInstance();

                DocumentReference washingtonRef = db.collection("Sheopur").document("Mobile Clinic #3 Date:05-27-2021");










                db.collection(districtname.getText().toString().toUpperCase()).document("Mobile Clinic #" + clinicname.getText().toString() + "  Date:" + date.getText().toString())
                        .set(DiagnoseIllnessData,SetOptions.merge())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                                Toast.makeText(DiagnoseIllness.this, "Medical Assesment Uploaded to Database", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                                Toast.makeText(DiagnoseIllness.this, "Error Uploading Medical Assesment to Database", Toast.LENGTH_SHORT).show();
                            }
                        });
















            }
        });


        //spinner code


        Spinner spin = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);








    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "Select Problem: "+users[position] ,Toast.LENGTH_SHORT).show();
        // add

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}





