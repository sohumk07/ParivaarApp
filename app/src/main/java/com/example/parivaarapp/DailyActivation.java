package com.example.parivaarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.text.TextUtils;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.google.firebase.auth.FirebaseAuth;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
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
import java.text.SimpleDateFormat;
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
import com.google.firebase.firestore.Query;
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

    EditText doctor, medattendant, driver, vehiclestartmileage, vehicleendmileage, villagesvisited, totaldistance, clinicname1, date, remarks, starttime, endtime;
    private String districtName;
    private String clinicName;
    ImageView addphoto;
    Button update, menubtn;
    String date1;
    String time;


    Calendar calendar;
    SimpleDateFormat simpleDateFormat, simpleDateFormat1;
    String Date1;
    String Time;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

// intent stuff
        Intent intent = getIntent();
        districtName = intent.getStringExtra("DISTRICT_NAME_KEY");
        clinicName = intent.getStringExtra("CLINIC_NAME_KEY");


        Toast.makeText(this, "DISTRICT NAME IS: " + districtName, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "CLINIC NAME IS: " + clinicName, Toast.LENGTH_SHORT).show();


        ActionBar actionBar = getSupportActionBar();

        actionBar.setSubtitle(districtName + ", Clinic # " + clinicName);
        actionBar.setTitle("Daily Activation");















        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_activation);

        //final Calendar calendar = Calendar.getInstance();
        //final int year = calendar.get(Calendar.YEAR);
        //final int month = calendar.get(Calendar.MONTH);
        //final int day = calendar.get(Calendar.DAY_OF_MONTH);




//        districtname = findViewById(R.id.fstTxt2);
//        starttime = findViewById(R.id.start_time);
//        endtime = findViewById(R.id.end_time);
        remarks = findViewById(R.id.remarks);
//        date = findViewById(R.id.date);
//        clinicname1 = findViewById(R.id.fstTxt);
        doctor = findViewById(R.id.daily_activation_doctor);
        medattendant = findViewById(R.id.daily_activation_medical_attendant);
//        vehicleendmileage = findViewById(R.id.vehicle_end_mileage);
//        totaldistance = findViewById(R.id.total_distance);
        driver = findViewById(R.id.daily_activation_driver);
        vehiclestartmileage = findViewById(R.id.daily_activation_medical_attendant);
        villagesvisited = findViewById(R.id.villages_visited);
        RegisterBtn= findViewById(R.id.update);
        //menubtn = findViewById(R.id.update2);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),DailyActivation.class));
            finish();
        }

       //Calendar c = Calendar.getInstance();
       // int hour = c.get(Calendar.HOUR_OF_DAY);
       // int minute = c.get(Calendar.MINUTE);

//        menubtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DailyActivation.this, com.example.parivaarapp.Menu.class);
//                startActivity(intent);
//            }
//        });







        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calendar = Calendar.getInstance();
                simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                simpleDateFormat1 = new SimpleDateFormat("HH:mm:ss");
                Date1 = simpleDateFormat.format(calendar.getTime());
                Time = simpleDateFormat1.format(calendar.getTime());

                String varDate = Date1;
                String varTime = Time;













               // if(TextUtils.isEmpty(date.getText().toString())){
               //     date.setError("Date is Required.");
                 //   Toast.makeText(DailyActivation.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
                   // return;
                //}


                if(TextUtils.isEmpty(doctor.getText().toString())){
                    doctor.setError("Name is Required.");
                    Toast.makeText(DailyActivation.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(medattendant.getText().toString())){
                    medattendant.setError("Doctor is Required.");
                    Toast.makeText(DailyActivation.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(driver.getText().toString())){
                    driver.setError("Medical Attendant is Required.");
                    Toast.makeText(DailyActivation.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(vehiclestartmileage.getText().toString())){
                    vehiclestartmileage.setError("Driver is Required.");
                    Toast.makeText(DailyActivation.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(villagesvisited.getText().toString())){
                    villagesvisited.setError("Driver is Required.");
                    Toast.makeText(DailyActivation.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
                    return;
                }

//                if(TextUtils.isEmpty(vehicleendmileage.getText().toString())){
//                    vehicleendmileage.setError("Cannot Be Empty.");
//                    Toast.makeText(DailyActivation.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
//                    return;
//                }

//                if(TextUtils.isEmpty(totaldistance.getText().toString())){
//                    totaldistance.setError("Cannot Be Empty.");
//                    Toast.makeText(DailyActivation.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
//                    return;
//                }

//                if(TextUtils.isEmpty(clinicname1.getText().toString())){
//                    clinicname1.setError("Cannot Be Empty.");
//                    Toast.makeText(DailyActivation.this, "Fill Out All Fields", Toast.LENGTH_SHORT).show();
//                    return;
//                }



                Map<String, Object> DailyActivation = new HashMap<>();
                // nothing in here

//  //              DailyActivation.put("clinicName", clinicname1.getText().toString().trim().toUpperCase());
//                DailyActivation.put("date", varDate);
//                DailyActivation.put("doctorName", doctor.getText().toString().trim());
//                DailyActivation.put("attendantName", medattendant.getText().toString().trim());
//                DailyActivation.put("driverName", driver.getText().toString().trim());
//                DailyActivation.put("startMileage", vehiclestartmileage.getText().toString().trim());
//                DailyActivation.put("endMileage", vehicleendmileage.getText().toString().trim());
//                DailyActivation.put("distanceTraveled", totaldistance.getText().toString().trim());
//                DailyActivation.put("districtsVisited", villagesvisited.getText().toString().trim());
//                DailyActivation.put("remarks", remarks.getText().toString().trim());


                // Map<String, Object> nestedData = new HashMap<>();



                // DailyActivation.put(clinicname1.getText().toString(), nestedData);


                //STUFF FOR EXPORTING


                Map<String, Object> DailyActivationData = new HashMap<>();
                //DailyActivationData.put("(a) Date", date.getText().toString().trim());

                if(clinicName.equals("1")){
                    DailyActivationData.put("(e) Villages Visited " + "Clinic #" + clinicName.trim().toUpperCase(), villagesvisited.getText().toString().trim());
                    DailyActivationData.put("(b) Distance Covered (KM) " + "Clinic #" + clinicName.trim().toUpperCase(), totaldistance.getText().toString().trim());
                    DailyActivationData.put("(p) Starting Time " + "Clinic #" + clinicName.trim().toUpperCase(), varTime); //add clinic name to this field
                    DailyActivationData.put("(q) Ending Time " + "Clinic #" + clinicName.trim().toUpperCase(),varTime);

                }
//test
                else if(clinicName.equals("2")) {
                    DailyActivationData.put("(f) Villages Visited " + "Clinic #" + clinicName.trim().toUpperCase(), villagesvisited.getText().toString().trim());
                    DailyActivationData.put("(c) Distance Covered (KM) " + "Clinic #" + clinicName.trim().toUpperCase(), totaldistance.getText().toString().trim());
                    DailyActivationData.put("(r) Starting Time " + "Clinic #" + clinicName.trim().toUpperCase(), varTime); //add clinic name to this field
                    DailyActivationData.put("(q) Ending Time " + "Clinic #" + clinicName.trim().toUpperCase(),varTime);
                }
                else if(clinicName.equals("3")) {
                    DailyActivationData.put("(g) Villages Visited " + "Clinic #" + clinicName.trim().toUpperCase(), villagesvisited.getText().toString().trim());
                    DailyActivationData.put("(d) Distance Covered (KM) " + "Clinic #" + clinicName.trim().toUpperCase(), totaldistance.getText().toString().trim());
                    DailyActivationData.put("(t) Starting Time " + "Clinic #" + clinicName.trim().toUpperCase(), varTime); //add clinic name to this field
                    DailyActivationData.put("(q) Ending Time " + "Clinic #" + clinicName.trim().toUpperCase(),varTime);
                }

                if(remarks != null){
                    DailyActivationData.put("(f) Remarks ", "none");
                }
                else{
                    DailyActivationData.put("(f) Remarks ", remarks.getText().toString());

                }












//                //documents and collections
//                db.collection(districtName).document(varDate)
//                        .set(DailyActivationData,SetOptions.merge())
//                        .addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                Log.d(TAG, "DocumentSnapshot successfully written!");
//                                Toast.makeText(DailyActivation.this, "Daily Activation Uploaded to Database", Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .addOnFailureListener(new OnFailureListener() {
//                            @Override
//                            public void onFailure(@NonNull Exception e) {
//                                Log.w(TAG, "Error writing document", e);
//                                Toast.makeText(DailyActivation.this, "Error Uploading Daily Activation to Database", Toast.LENGTH_SHORT).show();
//                            }
//                        });




                // new collection for exporting
                db.collection(districtName).document(varDate) //put it in the document called the date, in the colleciton of the district.
                        .set(DailyActivationData,SetOptions.merge())
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

                Query query = db.collection(districtName.trim().toUpperCase()).orderBy("Villages Visited");









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
                Intent districtNameIntent = new Intent(DailyActivation.this, com.example.parivaarapp.Menu.class);

//
                districtNameIntent.putExtra("DISTRICT_NAME_KEY", districtName);
                districtNameIntent.putExtra("CLINIC_NAME_KEY", clinicName);
                //start intermediate
                startActivity(districtNameIntent);
                break;
            case R.id.sign_out:
                startActivity(new Intent(DailyActivation.this, MainActivity.class));
                break;
        }

        return super.onOptionsItemSelected(item);

    }




}


