



//RYAN

package com.example.parivaarapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.firestore.Query;

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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle("App Name");
        actionBar.setTitle("Admin View Patient Data");
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
        Query query = firebaseFirestore.collection("Patient Registration and-or Doctor's Notes");




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
                holder.name.setText("Patient Name: " + model.getIdentificationNum());
                holder.father_HusbandName.setText("Father/Husband's Name: " + model.getFather_HusbandName());
                holder.age.setText("Age: " + model.getAge());
                holder.identificationNum.setText("Identification Number: " + model.getIdentificationNum());
                holder.bloodPressure.setText("Blood Pressure: " + model.getBloodPressure());
                holder.weight.setText("Weight: " + model.getWeight());
                holder.bodyTemp.setText("Body Temperature: " + model.getBodyTemp());
                holder.bloodSugar.setText("Blood Sugar: " + model.getBloodSugar());

                //Doctor notes attributes
                holder.doctorNoteHeader.setText("Doctor's Notes for: " + model.getIdentificationNum());
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

            name = itemView.findViewById(R.id.patientID);
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

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.Menu:
                startActivity(new Intent(AdminPatientRegistration.this, AdminMenu.class));
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}

