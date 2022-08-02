



package com.example.parivaarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.File;
import java.util.ArrayList;
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
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

import android.os.Bundle;
import com.google.firebase.firestore.Query;

import org.w3c.dom.Text;

public class AdminPatientRegistration extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoreList;


    private FirestoreRecyclerAdapter adapter;


//    private String[] sortOptions = {"Most Recent", "Oldest", "By clinic"};
//
//    AutoCompleteTextView autoCompleteTextView;
//    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_patient_registration);

//        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
//
//        adapterItems = new ArrayAdapter<String>(this, R.layout.drop_down_item, sortOptions);
//        autoCompleteTextView.setAdapter(adapterItems);
//
//        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//                String item = parent.getItemAtPosition(position).toString();
//                Toast.makeText(getApplicationContext(), "Item: " + item, Toast.LENGTH_SHORT).show();
//            }
//        });









        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.patient_list); //the actual recycler view

        //Query
        Query query = firebaseFirestore.collection("/Patient Registration and-or Doctor's Notes");




        //RecyclerOptions
        FirestoreRecyclerOptions<PatientDataModel> options = new FirestoreRecyclerOptions.Builder<PatientDataModel>()
                .setQuery(query, PatientDataModel.class)
                .build();


        adapter = new FirestoreRecyclerAdapter<PatientDataModel, PatientDataHolder>(options) {
            @NonNull
            @Override
            public PatientDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_patient_data, parent, false);
                return new PatientDataHolder(view);
            }



            @Override
            protected void onBindViewHolder(@NonNull PatientDataHolder holder, int position, @NonNull PatientDataModel model) {
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
        mFirestoreList.setAdapter(adapter);











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
        adapter.stopListening();
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}
