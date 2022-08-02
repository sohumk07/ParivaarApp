package com.example.parivaarapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminMenu extends AppCompatActivity {

    private Button presetDataButton, dailyactivationButton, patientregistrationButton, doctorsnoteButton, signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Admin Navigation Menu");
        actionBar.setSubtitle("App Name");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        presetDataButton = (Button) findViewById(R.id.admin_presetData);
        dailyactivationButton = (Button) findViewById(R.id.button2);
        patientregistrationButton = (Button) findViewById(R.id.button3);
        doctorsnoteButton = (Button) findViewById(R.id.button4);
        signout = (Button) findViewById(R.id.adminsignout);






        presetDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMenu.this, AdminPresetData.class);
                startActivity(intent);
            }
        });

        dailyactivationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMenu.this, AdminDailyActivation.class);
                startActivity(intent);
            }
        });

        patientregistrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMenu.this, AdminPatientRegistration.class);
                startActivity(intent);
            }
        });

        doctorsnoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMenu.this, AdminPatientRegistration.class);
                startActivity(intent);
            }
        });


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMenu.this, Menu.class);
                startActivity(intent);
            }
        });
    }
}