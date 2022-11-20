package com.example.parivaarapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminMenu extends AppCompatActivity {

    private Button submitbutton, signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Admin Navigation Menu");
        actionBar.setSubtitle("App Name");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        submitbutton = (Button) findViewById(R.id.submit);
        signout = (Button) findViewById(R.id.adminsignout);






        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMenu.this, AdminPresetData.class);
                startActivity(intent);
            }
        });


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}