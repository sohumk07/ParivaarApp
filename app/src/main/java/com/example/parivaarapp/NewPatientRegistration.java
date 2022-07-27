package com.example.parivaarapp;

import androidx.appcompat.app.AppCompatActivity;
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
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

//RYAN CHANGE
public class NewPatientRegistration extends AppCompatActivity {

    public static final String TAG = "TAG";
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    private Button upload;


    public EditText fullname, patientregistrationphoto, patientregistrationhusbandname, patientregistrationage, patientregistrationidentification,patientregistrationbp, patientregistrationweight, patientregistrationbodytemperature, patientregistrationbloodsugar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient_registration);


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
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),DailyActivation.class));
            finish();
        }



        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



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




                Map<String, Object> NewPatientRegistration = new HashMap<>();


                Map<String, Object> nestedData = new HashMap<>();
                nestedData.put("Father/Husband Name",patientregistrationhusbandname.getText().toString().trim());
                nestedData.put("Age",patientregistrationage.getText().toString().trim());
                nestedData.put("Identification Number",patientregistrationidentification.getText().toString().trim());
                nestedData.put("Blood Pressure",patientregistrationbp.getText().toString().trim());
                nestedData.put("Weight",patientregistrationweight.getText().toString().trim());
                nestedData.put("Body Temperature",patientregistrationbodytemperature.getText().toString().trim());
                nestedData.put("Blood Sugar",patientregistrationbloodsugar.getText().toString().trim());

                NewPatientRegistration.put("Patient Registration Info", nestedData);


                db.collection("Patient Registration and-or Doctor's Notes").document(fullname.getText().toString().trim())
                        .set(NewPatientRegistration)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d(TAG, "DocumentSnapshot successfully written!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error writing document", e);
                            }
                        });







            }
        });



    }
}