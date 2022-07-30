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

public class AdminDailyActivation extends AppCompatActivity {

    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoreList;


    private FirestoreRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_daily_activation);







        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.firestore_list); //the actual recycler view

        //Query
        Query query = firebaseFirestore.collection("Daily Activation");
        //RecyclerOptions
        FirestoreRecyclerOptions<AdminDailyActivationModel> options = new FirestoreRecyclerOptions.Builder<AdminDailyActivationModel>()
                .setQuery(query, AdminDailyActivationModel.class)
                .build();


        adapter = new FirestoreRecyclerAdapter<AdminDailyActivationModel, DailyActivationViewHolder>(options) {
            @NonNull
            @Override
            public DailyActivationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent, false);
                return new DailyActivationViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull DailyActivationViewHolder holder, int position, @NonNull AdminDailyActivationModel model) {
                holder.clinicName.setText("Clinic Name: " + model.getClinicName());
                holder.date.setText("Date: " + model.getDate());
                holder.doctorName.setText("Doctor: " + model.getDoctorName());
                holder.attendantName.setText("Medical Attendant: " + model.getAttendantName());

                holder.driverName.setText("Driver: " + model.getDriverName());
                holder.districtsVisited.setText("Districts Visited " + model.getDistrictsVisited());
                holder.startMileage.setText("Vehicle started at " + model.getStartMileage() + " miles");
                holder.endMileage.setText("Vehicle ended at " + model.getEndMileage() + " miles");
                holder.endMileage.setText("Total Distance Traveled " + model.getDistanceTraveled() + " miles");






            }
        };

        mFirestoreList.setHasFixedSize(true);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(adapter);











    }




    private class DailyActivationViewHolder extends RecyclerView.ViewHolder {

        private TextView clinicName;
        private TextView date;
        private TextView doctorName;
        private TextView attendantName;
        private TextView driverName;
        private TextView districtsVisited;
        private TextView startMileage;
        private TextView endMileage;
        private TextView distanceTraveled;



        public DailyActivationViewHolder(@NonNull View itemView) {
            super(itemView);

            clinicName = itemView.findViewById(R.id.clinicName);
            date = itemView.findViewById(R.id.date);
            doctorName = itemView.findViewById(R.id.doctorName);
            attendantName = itemView.findViewById(R.id.attendantName);

            driverName = itemView.findViewById(R.id.driverName);
            districtsVisited = itemView.findViewById(R.id.districtsVisited);
            startMileage = itemView.findViewById(R.id.startMileage);
            endMileage = itemView.findViewById(R.id.endMileage);
            distanceTraveled = itemView.findViewById(R.id.distanceTraveled);




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
