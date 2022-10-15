package com.example.parivaarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.google.firebase.firestore.Query;
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


    //Recycler View (display prev info)
    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoreList;

    private FirestoreRecyclerAdapter adapter2;
    //

    EditText  doctorsnote, doctorsadvice, medicinesused, referral, followup, clinicname, districtname, date, patientID;
    String[] users = { "Fever", "Skin", "Chronic Disease", "Bp or Sugar", "Eye", "Other" };

    Calendar calendar;
    SimpleDateFormat simpleDateFormat, simpleDateFormat1;
    String Date1;
    String Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnose_illness);



        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
        Date1 = simpleDateFormat.format(calendar.getTime());
        Time = simpleDateFormat1.format(calendar.getTime());


        upload =findViewById(R.id.dn_upload);

        districtname = findViewById(R.id.district_name);
        // date = findViewById(R.id.date);
        clinicname = findViewById(R.id.clinic_name);
        patientID = findViewById(R.id.PatientID);
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

                String varDate = Date1;
                String varTime = Time;


                final String doctorsnotefullname1 = patientID.getText().toString().trim();
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
                    patientID.setError("Cannot Be Empty");
                    Toast.makeText(DiagnoseIllness.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();

                    return;
                }

                if(TextUtils.isEmpty(doctorsnotefullname1)){
                    patientID.setError("Cannot Be Empty");
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
                db.collection("Patient Registration and-or Doctor's Notes").document(patientID.getText().toString().trim().toUpperCase())
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

                                newDataDocument.put("(p) Starting Time " + "Clinic #" + 1, ""); //add clinic name to this field
                                newDataDocument.put("(q) Leaving Time " + "Clinic #" + 1,varTime);

                                newDataDocument.put("(r) Starting Time " + "Clinic #" + 2, ""); //add clinic name to this field
                                newDataDocument.put("(s) Leaving Time " + "Clinic #" + 2,varTime);

                                newDataDocument.put("(t) Starting Time " + "Clinic #" + 3, ""); //add clinic name to this field
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








            }
        });


        //spinner code


        Spinner spin = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);



    //Code for recylerView for previous patient Data
        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.DN_patient_list); //the actual recycler view
        Query query = firebaseFirestore.collection("Patient Registration and-or Doctor's Notes").whereEqualTo("identificationNum", patientID);


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
                holder.name.setText("Patient Name: " + model.getName());
                holder.father_HusbandName.setText("Father/Husband's Name: " + model.getFather_HusbandName());
                holder.age.setText("Age: " + model.getAge());
                holder.identificationNum.setText("Identification Number: " + model.getIdentificationNum());
                holder.bloodPressure.setText("Blood Pressure: " + model.getBloodPressure());
                holder.weight.setText("Weight: " + model.getWeight());
                holder.bodyTemp.setText("Body Temperature: " + model.getBodyTemp());
                holder.bloodSugar.setText("Blood Sugar: " + model.getBloodSugar());

                //Doctor notes attributes
                holder.doctorNoteHeader.setText("Doctor's Notes for: " + model.getName());
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

//test
    }

    private class PatientDataHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView father_HusbandName;
        private TextView age;
        private TextView identificationNum;
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

            name = itemView.findViewById(R.id.name);
            father_HusbandName = itemView.findViewById(R.id.fatherHusbandName);
            age = itemView.findViewById(R.id.age);
            identificationNum = itemView.findViewById(R.id.identificationNum);

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





