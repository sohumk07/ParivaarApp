package com.example.parivaarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.google.firebase.auth.FirebaseAuth;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.SetOptions;

import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import androidx.appcompat.app.ActionBar;
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

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.SetOptions;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class DiagnoseIllness extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private boolean needOfReferral = false;
    private Button button;
    public static final String TAG = "TAG";
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    private Button upload;
    private int numberofcases = 0;
    private String conditionSelected;


    //Recycler View (display prev info)
    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoreList;

    private FirestoreRecyclerAdapter adapter2;
    //

    EditText doctorsadvice, medicinesused, referral, followup, clinicname, districtname, date, patientID;
    TextView doctorsnote;
    String[] users = { "Fever", "Skin", "Chronic Disease", "Bp or Sugar", "Eye", "Other" };

    Calendar calendar;
    SimpleDateFormat simpleDateFormat, simpleDateFormat1;
    String Date1;
    String Time;



    //Patient Registration

    public EditText fullname, patientregistrationphoto, patientregistrationhusbandname, patientregistrationage, patientregistrationidentification,patientregistrationbp, patientregistrationweight, patientregistrationbodytemperature, patientregistrationbloodsugar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose_illness);
        Intent receiverIntent = getIntent();
        String realPatientID = receiverIntent.getStringExtra("KEY_PATIENT");

        //getting patient ID from intermediate
        //String realPatientID = recieverIntent.getStringExtra("KEY_PATIENT_ID");





        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
        Date1 = simpleDateFormat.format(calendar.getTime());
        Time = simpleDateFormat1.format(calendar.getTime());


        upload =findViewById(R.id.dn_upload);

        districtname = findViewById(R.id.district_name);
        // date = findViewById(R.id.date);
        clinicname = findViewById(R.id.clinic_name);
    //    patientID = findViewById(R.id.PatientID);
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


        //Code for recylerView for previous patient Data
        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.DN_patient_list); //the actual recycler view
        Toast.makeText(this, realPatientID, Toast.LENGTH_SHORT).show();
        Query query = firebaseFirestore.collection("Patient Registration and-or Doctor's Notes").whereEqualTo("identificationNum", realPatientID);

        //RecyclerOptions
        FirestoreRecyclerOptions<PatientDataModel> options = new FirestoreRecyclerOptions.Builder<PatientDataModel>()
                .setQuery(query, PatientDataModel.class)
                .build();


        adapter2 = new FirestoreRecyclerAdapter<PatientDataModel, DiagnoseIllness.PatientDataHolder>(options) {
            @NonNull
            @Override
            public DiagnoseIllness.PatientDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_patient_data, parent, false);
                return new DiagnoseIllness.PatientDataHolder(view);
            }



            @Override
            protected void onBindViewHolder(@NonNull DiagnoseIllness.PatientDataHolder holder, int position, @NonNull PatientDataModel model) {
                holder.patientID.setText("Patient Name: " + model.getPatientID());
                holder.father_HusbandName.setText("Father/Husband's Name: " + model.getFather_HusbandName());
                holder.age.setText("Age: " + model.getAge());
                holder.patientID.setText("Identification Number: " + model.getPatientID());
                holder.bloodPressure.setText("Blood Pressure: " + model.getBloodPressure());
                holder.weight.setText("Weight: " + model.getWeight());
                holder.bodyTemp.setText("Body Temperature: " + model.getBodyTemp());
                holder.bloodSugar.setText("Blood Sugar: " + model.getBloodSugar());

                //Doctor notes attributes
                holder.doctorNoteHeader.setText("Doctor's Notes for: " + model.getPatientID());
                holder.doctorNote.setText("Doctor's Description: " + model.getDoctorNote());
                holder.doctorAdvice.setText("Doctor's advice: " + model.getDoctorAdvice());
                holder.medicinesUsed.setText("Medicines Used: " + model.getMedicinesUsed());
                holder.followUpNeeded.setText("Follow up needed:  " + model.getFollowUpNeeded());
                holder.needOfReferral.setText("Need of referral: " + model.getNeedOfReferral());

            }
        };

        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter2);



        // Patient Registration
        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle("App Name");
        actionBar.setTitle("Patient Registration");




        fullname = findViewById(R.id.full_name);
        //patientregistrationphoto = findViewById(R.id.patient_registration_photo);
        patientregistrationhusbandname = findViewById(R.id.patient_registration_husband_name);
        patientregistrationage = findViewById(R.id.patient_registration_age);
        patientregistrationidentification = findViewById(R.id.patient_registration_identification);
        patientregistrationbp = findViewById(R.id.patient_registration_bp);
        patientregistrationweight = findViewById(R.id.patient_registration_weight);
        patientregistrationbodytemperature = findViewById(R.id.patient_registration_body_temperature);
        patientregistrationbloodsugar = findViewById(R.id.patient_registration_blood_sugar);
        upload = findViewById(R.id.patient_registration_button);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),DailyActivation.class));
            finish();
        }









        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String varDate = Date1;
                String varTime = Time;


                final String doctorsadvice1 = doctorsadvice.getText().toString().trim();
                final String medicinesused1 = medicinesused.getText().toString().trim();
                final String followup1 = followup.getText().toString().trim();
                final String referral1 = referral.getText().toString().trim();










                if(TextUtils.isEmpty(clinicname.getText().toString())){
                    clinicname.setError("Cannot Be Empty");
                    Toast.makeText(DiagnoseIllness.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
                    return;
                }

//                if(TextUtils.isEmpty(patientID)){
//                    patientID.setError("Cannot Be Empty");
//                    Toast.makeText(DiagnoseIllness.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
//
//                    return;
//                }
//
//                if(TextUtils.isEmpty(doctorsnotefullname1)){
//                    patientID.setError("Cannot Be Empty");
//                    Toast.makeText(DiagnoseIllness.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
//
//                    return;
//                }

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
                db.collection("Patient Registration and-or Doctor's Notes").document(realPatientID)
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
                // String varDate = date.getText().toString().trim();

                DocumentReference docIdRef = db.collection(districtname.getText().toString().trim().toUpperCase()).document(varDate); //NEEDS FIXING MAYBE
                docIdRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) { // increment the counter                                  // Look in the collection with inputted district and document w/ inputted date

                                DocumentReference incrementCases = db.collection(districtname.getText().toString().toUpperCase().trim()).document(varDate);

                                if(clinicname.getText().toString().toUpperCase().trim().equals("1")){
                                    incrementCases.update("(h) Cases " + "Clinic # " + clinicname.getText().toString().toUpperCase().trim(), FieldValue.increment(1));
                                    if(referral.getText().toString().trim().toLowerCase().equals("yes")){ //if they wanted to refer
                                        incrementCases.update( "(k) Clinic # " + clinicname.getText().toString().toUpperCase().trim() + " Referred to HC", FieldValue.increment(1));
                                    }
                                }
                                else if(clinicname.getText().toString().toUpperCase().trim().equals("2")){
                                    incrementCases.update("(i) Cases " + "Clinic # " + clinicname.getText().toString().toUpperCase().trim(), FieldValue.increment(1));
                                    if(referral.getText().toString().trim().toLowerCase().equals("yes")){ //if they watned to refer
                                        incrementCases.update( "(l) Clinic # " + clinicname.getText().toString().toUpperCase().trim() + " Referred to HC", FieldValue.increment(1));
                                    }
                                }
                                else if(clinicname.getText().toString().toUpperCase().trim().equals("3")){
                                    incrementCases.update("(j) Cases " + "Clinic # " + clinicname.getText().toString().toUpperCase().trim(), FieldValue.increment(1));
                                    if(referral.getText().toString().trim().toLowerCase().equals("yes")){ //if they watned to refer
                                        incrementCases.update( "(m) Clinic # " + clinicname.getText().toString().toUpperCase().trim() + " Referred to HC", FieldValue.increment(1));
                                    }
                                }
                                incrementCases.update("(v) "+ conditionSelected + " Cases ", FieldValue.increment(1));


                            } else { //create a new document for that day with ALL ATTRIBUTES THAT MIGHT BE READ IN

                                //tests
                                //Log.d(TAG, "DATE: " + varDate);



                                newDataDocument.put("(a) Date ", varDate);

                                newDataDocument.put("(b) Distance Covered (KM) " + "Clinic #" + 1, 0);
                                newDataDocument.put("(c) Distance Covered (KM) " + "Clinic #" + 2, 0);
                                newDataDocument.put("(d) Distance Covered (KM) " + "Clinic #" + 3, 0);

                                newDataDocument.put("(e) Villages Visited " + "Clinic #" + 1, "");
                                newDataDocument.put("(f) Villages Visited " + "Clinic #" + 2, "");
                                newDataDocument.put("(g) Villages Visited " + "Clinic #" + 3, "");

                                newDataDocument.put("(h) Cases " +  "Clinic # " + 1, 0);
                                newDataDocument.put("(i) Cases " +  "Clinic # " + 2, 0);
                                newDataDocument.put("(j) Cases " +  "Clinic # " + 3, 0);

                                newDataDocument.put("(k) Clinic # " + 1 + " Referred to HC", 0);
                                newDataDocument.put("(l) Clinic # " + 2 + " Referred to HC", 0);
                                newDataDocument.put("(m) Clinic # " + 3 + " Referred to HC", 0);

                                newDataDocument.put("(o) Remarks ","");

                                newDataDocument.put("(p) Starting Time " + "Clinic #" + 1, varTime); //add clinic name to this field
                                newDataDocument.put("(q) Leaving Time " + "Clinic #" + 1,varTime);

                                newDataDocument.put("(r) Starting Time " + "Clinic #" + 2, varTime); //add clinic name to this field
                                newDataDocument.put("(s) Leaving Time " + "Clinic #" + 2,varTime);

                                newDataDocument.put("(t) Starting Time " + "Clinic #" + 3, varTime); //add clinic name to this field
                                newDataDocument.put("(u) Leaving Time " + "Clinic #" + 3,varTime);

                                newDataDocument.put("(v) Fever" + " Cases ", 0);
                                newDataDocument.put("(v) Skin" + " Cases ", 0);
                                newDataDocument.put("(v) Chronic Disease" + " Cases ", 0);
                                newDataDocument.put("(v) Bp or Sugar" + " Cases ", 0);
                                newDataDocument.put("(v) Eye" + " Cases ", 0);
                                newDataDocument.put("(v) Other" + " Cases ", 0);

                                newDataDocument.put("(v) " + conditionSelected + " Cases ", 1);



                                if(referral.getText().toString().trim().toLowerCase().equals("yes")){ //if they watned to refer
                                    if(clinicname.getText().toString().toUpperCase().trim().equals("1")){
                                        newDataDocument.put( "(k) Clinic # " + clinicname.getText().toString().toUpperCase().trim() + " Referred to HC", 1);

                                    }
                                    else if(clinicname.getText().toString().toUpperCase().trim().equals("2")){
                                        newDataDocument.put( "(l) Clinic # " + clinicname.getText().toString().toUpperCase().trim() + " Referred to HC", 1);

                                    }
                                    else if(clinicname.getText().toString().toUpperCase().trim().equals("3")){
                                        newDataDocument.put("(m) Clinic # " + clinicname.getText().toString().toUpperCase().trim() + " Referred to HC", 1);
                                    }

                                }



//                                //daily activation
//                                newDataDocument.put("Starting Time " + "Clinic # " + clinicname.getText().toString().trim().toUpperCase(), " ");
//                                newDataDocument.put("Leaving Time " + "Clinic # " + clinicname.getText().toString().trim().toUpperCase(), " ");
//                                newDataDocument.put("Distance Covered (KM) " + "Clinic # " + clinicname.getText().toString().trim().toUpperCase(), " ");
//                                newDataDocument.put("Villages Visited", " ");




                                db.collection(districtname.getText().toString().trim().toUpperCase()).document(varDate)
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








                //Patient Registration

                final String fullname_1 = fullname.getText().toString().trim();
                final String patientregistrationhusbandname_1 = patientregistrationhusbandname.getText().toString().trim();
                final String patientregistrationage_1 = patientregistrationage.getText().toString().trim();
                final String patientregistrationidentification_1 = patientregistrationidentification.getText().toString().trim();
                final String patientregistrationbp_1 = patientregistrationbp.getText().toString().trim();
                final String patientregistrationweight_1 = patientregistrationweight.getText().toString().trim();
                final String patientregistrationbodytemperature_1 = patientregistrationbodytemperature.getText().toString().trim();
                final String patientregistrationbloodsugar_1 = patientregistrationbloodsugar.getText().toString().trim();


                if(TextUtils.isEmpty(fullname_1)){
                    fullname.setError("Cannot Be Empty");
                    return;
                }

                if(TextUtils.isEmpty(patientregistrationhusbandname_1)){
                    patientregistrationhusbandname.setError("Cannot Be Empty");
                    return;
                }

                if(TextUtils.isEmpty(patientregistrationage_1)){
                    patientregistrationage.setError("Cannot Be Empty");
                    return;
                }

                if(TextUtils.isEmpty(patientregistrationidentification_1)){
                    patientregistrationidentification.setError("Cannot Be Empty");
                    return;
                }

                if(TextUtils.isEmpty(patientregistrationbp_1)){
                    patientregistrationbp.setError("Cannot Be Empty");
                    return;
                }

                if(TextUtils.isEmpty(patientregistrationweight_1)){
                    patientregistrationweight.setError("Cannot Be Empty");
                    return;
                }


                if(TextUtils.isEmpty(patientregistrationbodytemperature_1)){
                    patientregistrationbodytemperature.setError("Cannot Be Empty");
                    return;
                }


                if(TextUtils.isEmpty(patientregistrationbloodsugar_1)){
                    patientregistrationbloodsugar.setError("Cannot Be Empty");
                    return;
                }



//
                Map<String, Object> NewPatientRegistration = new HashMap<>();
                NewPatientRegistration.put("name", fullname.getText().toString().trim().toUpperCase());
                NewPatientRegistration.put("father_HusbandName",patientregistrationhusbandname.getText().toString().trim());
                NewPatientRegistration.put("age",Integer.parseInt(patientregistrationage.getText().toString().trim()));
                NewPatientRegistration.put("identificationNum",patientregistrationidentification.getText().toString().trim());
                NewPatientRegistration.put("bloodPressure",Integer.parseInt(patientregistrationbp.getText().toString().trim()));
                NewPatientRegistration.put("weight",Integer.parseInt(patientregistrationweight.getText().toString().trim()));
                NewPatientRegistration.put("bodyTemp",Integer.parseInt(patientregistrationbodytemperature.getText().toString().trim()));
                NewPatientRegistration.put("bloodSugar",Integer.parseInt(patientregistrationbloodsugar.getText().toString().trim()));


                //Map<String, Object> nestedData = new HashMap<>();


                //NewPatientRegistration.put("Patient Registration Info", nestedData);


                db.collection("Patient Registration and-or Doctor's Notes").document(fullname.getText().toString().trim().toUpperCase())
                        .set(NewPatientRegistration, SetOptions.merge())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                                Toast.makeText(DiagnoseIllness.this, "Patient Information Uploaded to Database", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                                Toast.makeText(DiagnoseIllness.this, "Error Uploading Patient Information to Database", Toast.LENGTH_SHORT).show();
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


//test
    }

    private class PatientDataHolder extends RecyclerView.ViewHolder {

        private TextView patientID;
        private TextView father_HusbandName;
        private TextView age;
        private TextView bloodPressure;
        private TextView weight;
        private TextView bodyTemp;
        private TextView bloodSugar;
        private TextView doctorNoteHeader;
        private TextView doctorNote;
        private TextView doctorAdvice;
        private TextView medicinesUsed;
        private TextView followUpNeeded;
        private TextView needOfReferral;





        public PatientDataHolder(@NonNull View itemView) {
            super(itemView);

            father_HusbandName = itemView.findViewById(R.id.fatherHusbandName);
            age = itemView.findViewById(R.id.age);
            patientID = itemView.findViewById(R.id.patientID);

            bloodPressure = itemView.findViewById(R.id.bloodPressure);
            weight  = itemView.findViewById(R.id.weight);
            bodyTemp = itemView.findViewById(R.id.bodyTemp);
            bloodSugar = itemView.findViewById(R.id.bloodSugar);
            doctorNote = itemView.findViewById(R.id.doctorsNote);
            doctorAdvice = itemView.findViewById(R.id.doctorAdvice);
            medicinesUsed = itemView.findViewById(R.id.medicinesUsed);
            followUpNeeded = itemView.findViewById(R.id.followUpNeeded);
            needOfReferral = itemView.findViewById(R.id.referralNeeded);
            doctorNoteHeader = itemView.findViewById(R.id.doctorNoteHeader);

        }



    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter2.stopListening();
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter2.startListening();
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
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.Menu:
                startActivity(new Intent(DiagnoseIllness.this, Menu.class));
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}





