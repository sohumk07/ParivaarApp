package com.example.parivaarapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
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
import android.widget.ImageView;
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

import java.util.Calendar;

public class DailyActivation extends AppCompatActivity {

    public static final String TAG = "TAG";
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    Button RegisterBtn;

    EditText doctor, medattendant, driver, vehiclestartmileage, vehicleendmileage, districtsvisited, totaldistance, clinicname1, date;
    ImageView addphoto;
    Button update;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Daily Activation");
        actionBar.setSubtitle("App Name");




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_activation);

        //final Calendar calendar = Calendar.getInstance();
        //final int year = calendar.get(Calendar.YEAR);
        //final int month = calendar.get(Calendar.MONTH);
        //final int day = calendar.get(Calendar.DAY_OF_MONTH);




        date = findViewById(R.id.date);
        clinicname1 = findViewById(R.id.fstTxt);
        doctor = findViewById(R.id.daily_activation_doctor);
        medattendant = findViewById(R.id.daily_activation_medical_attendant);
        vehicleendmileage = findViewById(R.id.vehicle_end_mileage);
        totaldistance = findViewById(R.id.total_distance);
        driver = findViewById(R.id.daily_activation_driver);
        vehiclestartmileage = findViewById(R.id.daily_activation_medical_attendant);
        districtsvisited = findViewById(R.id.districts_visited);
        addphoto = findViewById(R.id.add_photo);
        RegisterBtn= findViewById(R.id.update);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),DailyActivation.class));
            finish();
        }

        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);





        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                final String date1 = date.getText().toString();
                final String clinicname2 = clinicname1.getText().toString();
                final String doctor1 = doctor.getText().toString();
                final String medattendant1 = medattendant.getText().toString();
                final String driver1 = driver.getText().toString();
                final String vehiclestartmileage1 = vehiclestartmileage.getText().toString();
                final String districtsvisited1 = districtsvisited.getText().toString();
                final String vehicleendmileage1 = vehicleendmileage.getText().toString();
                final String totaldistance1 = totaldistance.getText().toString();






                if(TextUtils.isEmpty(date1)){
                    date.setError("Date is Required.");
                    return;
                }


                if(TextUtils.isEmpty(doctor1)){
                    doctor.setError("Name is Required.");
                    return;
                }

                if(TextUtils.isEmpty(medattendant1)){
                    medattendant.setError("Doctor is Required.");
                    return;
                }

                if(TextUtils.isEmpty(driver1)){
                    driver.setError("Medical Attendant is Required.");
                    return;
                }

                if(TextUtils.isEmpty(vehiclestartmileage1)){
                    vehiclestartmileage.setError("Driver is Required.");
                    return;
                }

                if(TextUtils.isEmpty(districtsvisited1)){
                    districtsvisited.setError("Driver is Required.");
                    return;
                }

                if(TextUtils.isEmpty(vehicleendmileage1)){
                    vehicleendmileage.setError("Cannot Be Empty.");
                    return;
                }

                if(TextUtils.isEmpty(totaldistance1)){
                    totaldistance.setError("Cannot Be Empty.");
                    return;
                }

                if(TextUtils.isEmpty(clinicname2)){
                    clinicname1.setError("Cannot Be Empty.");
                    return;
                }



                Map<String, Object> DailyActivation = new HashMap<>();
                DailyActivation.put("clinicName", clinicname1.getText().toString().trim());
                DailyActivation.put("date", date.getText().toString().trim());
                DailyActivation.put("doctorName", doctor.getText().toString().trim());
                DailyActivation.put("attendantName", medattendant.getText().toString().trim());
                DailyActivation.put("driverName", driver.getText().toString().trim());
                DailyActivation.put("startMileage", vehiclestartmileage.getText().toString().trim());
                DailyActivation.put("endMileage", vehicleendmileage.getText().toString().trim());
                DailyActivation.put("distanceTraveled", totaldistance.getText().toString().trim());


                Map<String, Object> nestedData = new HashMap<>();



                // DailyActivation.put(clinicname1.getText().toString(), nestedData);








                //documents and collections
                db.collection("Daily Activation").document(date.getText().toString().trim())
                        .set(DailyActivation, SetOptions.merge())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                                Toast.makeText(DailyActivation.this, "Daily Activation Uploaded to Database", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                                Toast.makeText(DailyActivation.this, "Error Uploading Daily Activation to Database", Toast.LENGTH_SHORT).show();
                            }
                        });








            }
        });

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
                startActivity(new Intent(DailyActivation.this, com.example.parivaarapp.Menu.class));
                break;
        }
        return super.onOptionsItemSelected(item);

    }




}


