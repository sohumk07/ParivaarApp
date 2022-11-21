package com.example.parivaarapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminMenu extends AppCompatActivity {

    private Button adminmedicine, admindoctor, signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Admin Navigation Menu");
        actionBar.setSubtitle("App Name");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        adminmedicine = (Button) findViewById(R.id.medicinebutton);
        admindoctor = (Button) findViewById(R.id.doctorbutton);
        signout = (Button) findViewById(R.id.adminsignout);






        adminmedicine.setOnClickListener(new View.OnClickListener() {
          @Override
         public void onClick(View view) {
               Intent intent = new Intent(AdminMenu.this, adminmedicine.class);
               startActivity(intent);

               //add sender stuff
            }
       });

        admindoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMenu.this, admindoctor.class);
                startActivity(intent);

                //add sender stuff
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