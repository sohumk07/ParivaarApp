package com.example.parivaarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
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
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
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
import com.google.firestore.v1.WriteResult;

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

    private boolean needOfReferral = false;
    private Button button;
    public static final String TAG = "TAG";
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    private Button upload;
    private int numberofcases = 0;
    private String conditionSelected;

    EditText doctorsnotefullname, doctorsnote, doctorsadvice, medicinesused, referral, followup, clinicname, districtname, date;
    String[] users = { "Fever", "Skin", "Chronic Disease", "Bp or Sugar", "Eye", "Other" };

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

                if(!(referral1.equals("yes") || (referral1.equals("no")))){
                //code if condition is false
                    referral.setError("Must Write 'yes' or 'no' ");
                    Toast.makeText(DiagnoseIllness.this, "Error", Toast.LENGTH_SHORT).show();

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
                //Map<String, Object> DiagnoseIllnessData = new HashMap<>();
                //DiagnoseIllnessData.put("Number Of Cases", numberofcases += 1);

                Map<String, Object> newDataDocument = new HashMap<>();


                //CHECKING IF DOCUMENT EXISTS OR NOT IN EXPORTING COLLECTIONS
                String varDate = date.getText().toString().trim();

                DocumentReference docIdRef = db.collection(districtname.getText().toString().trim().toUpperCase()).document(varDate); //NEEDS FIXING MAYBE
                docIdRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) { // increment the counter                                  // Look in the collection with inputted district and document w/ inputted date

                                DocumentReference incrementCases = db.collection(districtname.getText().toString().toUpperCase().trim()).document(date.getText().toString().trim());
                                incrementCases.update("Cases " + "Clinic # " + clinicname.getText().toString().toUpperCase().trim(), FieldValue.increment(1));
                                incrementCases.update(conditionSelected + " Cases ", FieldValue.increment(1));
                                if(referral.getText().toString().trim().toLowerCase().equals("yes")){ //if they watned to refer
                                    incrementCases.update( "Clinic # " + clinicname.getText().toString().toUpperCase().trim() + " Referred to HC", FieldValue.increment(1));
                                }



                            } else { //create a new document for that day with ALL ATTRIBUTES THAT MIGHT BE READ IN

                                //tests
                                //Log.d(TAG, "DATE: " + varDate);

                                newDataDocument.put("Fever" + " Cases ", 0);
                                newDataDocument.put("Skin" + " Cases ", 0);
                                newDataDocument.put("Chronic Disease" + " Cases ", 0);
                                newDataDocument.put("Bp or Sugar" + " Cases ", 0);
                                newDataDocument.put("Eye" + " Cases ", 0);
                                newDataDocument.put("Other" + " Cases ", 0);

                                newDataDocument.put(conditionSelected + " Cases ", 1);
                                newDataDocument.put("(a) Date ", varDate);

                                newDataDocument.put("Cases " +  "Clinic # " + 1, 0);
                                newDataDocument.put("Cases " +  "Clinic # " + 2, 0);
                                newDataDocument.put("Cases " +  "Clinic # " + 3, 0);

                                newDataDocument.put("Clinic # " + 1 + " Referred to HC", 0);
                                newDataDocument.put("Clinic # " + 2 + " Referred to HC", 0);
                                newDataDocument.put("Clinic # " + 3 + " Referred to HC", 0);


                                if(referral.getText().toString().trim().toLowerCase().equals("yes")){ //if they watned to refer
                                    newDataDocument.put("Clinic # " + clinicname.getText().toString().toUpperCase().trim() + " Referred to HC", 1);
                                }


//                                //daily activation
//                                newDataDocument.put("Starting Time " + "Clinic # " + clinicname.getText().toString().trim().toUpperCase(), " ");
//                                newDataDocument.put("Leaving Time " + "Clinic # " + clinicname.getText().toString().trim().toUpperCase(), " ");
//                                newDataDocument.put("Distance Covered (KM) " + "Clinic # " + clinicname.getText().toString().trim().toUpperCase(), " ");
//                                newDataDocument.put("Villages Visited", " ");




                                db.collection(districtname.getText().toString().trim().toUpperCase()).document(date.getText().toString().trim())
                                        .set(newDataDocument,SetOptions.merge())
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG, "DocumentSnapshot successfully written!");
                                                Toast.makeText(DiagnoseIllness.this, "Daily Activation Uploaded to Database", Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Log.w(TAG, "Error writing document", e);
                                                Toast.makeText(DiagnoseIllness.this, "Error Uploading Daily Activation to Database", Toast.LENGTH_SHORT).show();
                                            }
                                        });

                               // newDataDocument.put("Leaving Time " + clinicname.getText().toString().trim().toUpperCase(), "");


                            }
                        } else {
                            Log.d(TAG, "Failed with: ", task.getException());
                        }
                    }
                });




                // doctors note
                //newDataDocument.put("Cases " + "Clinic # " + clinicname.getText().toString().toUpperCase().trim(), 1);

                //separated cases by category
                //newDataDocument.put(conditionSelected + " Cases ", 1);
//                                newDataDocument.put("Fever" + " Cases ", 0);
//                                newDataDocument.put("Skin" + " Cases ", 0);
//                                newDataDocument.put("Chronic Disease" + " Cases ", 0);
//                                newDataDocument.put("Bp/Sugar" + " Cases ", 0);
//                                newDataDocument.put("Eye" + " Cases ", 0);
//                                newDataDocument.put("Other" + " Cases ", 0);


                Log.d(TAG, "New document created!");








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
        conditionSelected = (String)(users[position]);



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}





