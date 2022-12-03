package com.example.parivaarapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu extends AppCompatActivity {
    private Button button;
    EditText districtname;
    EditText clinicname;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Navigation Menu");

        districtname = (EditText)  findViewById(R.id.textView876);
        clinicname = (EditText)  findViewById(R.id.textView11);




        // go to preset data
        button=findViewById(R.id.preset_data);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code
                Intent intent = new Intent(Menu.this,PresetData.class);
                startActivity(intent);

            }
        });

        //go to daily activation

        button=findViewById(R.id.daily_activation);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                //code
//                Intent intent = new Intent(Menu.this,DailyActivation.class);
//                startActivity(intent);
//
//
//                //add sender stuff
//                Intent senderIntent = new Intent(Menu.this, DailyActivation.class);
//                senderIntent.putExtra("DISTRICT_NAME_KEY", districtname.getText().toString());
//                startActivity(senderIntent);
            }
        });

        //go to diagnose illness

        button=findViewById(R.id.diagnose_illness);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code

                //add sender stuff
                Intent districtNameIntent = new Intent(Menu.this, intermediate.class);
                districtNameIntent.putExtra("DISTRICT_NAME_KEY", districtname.getText().toString().toUpperCase().trim());
                districtNameIntent.putExtra("CLINIC_NAME_KEY", clinicname.getText().toString().toUpperCase().trim());
                //start intermediate
                startActivity(districtNameIntent);


            }
        });

        //go to diagnose illness

//        button=findViewById(R.id.Patient_Registration);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //code
//                Intent intent = new Intent(Menu.this,NewPatientRegistration.class);
//                startActivity(intent);
//
//
//                //add sender stuff
//                Intent senderIntent = new Intent(Menu.this, DiagnoseIllness.class);
//                senderIntent.putExtra("KEY_SENDER", districtname.getText().toString());
//                startActivity(senderIntent);
//            }
//        });


        //sign out
        // to homepage

        button=findViewById(R.id.sign_out);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code
                Intent intent = new Intent(Menu.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }


}



