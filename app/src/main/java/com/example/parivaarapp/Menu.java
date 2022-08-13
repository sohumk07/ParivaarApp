package com.example.parivaarapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Navigation Menu");
        actionBar.setSubtitle("App Name");
        //test2


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
                //code
                Intent intent = new Intent(Menu.this,DailyActivation.class);
                startActivity(intent);
            }
        });

        //go to diagnose illness

        button=findViewById(R.id.diagnose_illness);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code
                Intent intent = new Intent(Menu.this,DiagnoseIllness.class);
                startActivity(intent);
            }
        });

        //go to diagnose illness

        button=findViewById(R.id.Patient_Registration);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code
                Intent intent = new Intent(Menu.this,NewPatientRegistration.class);
                startActivity(intent);
            }
        });


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



