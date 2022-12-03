package com.example.parivaarapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ClinicLogin extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Login;
    EditText districtname;
    EditText clinicname;



    @Override //
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_login);

        districtname = (EditText)  findViewById(R.id.textView876);
        clinicname = (EditText)  findViewById(R.id.textView11);



//Code to change text of the toolbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle("App Name");
        actionBar.setTitle("Clinic Login Screen");
        actionBar.setDisplayHomeAsUpEnabled(true);


        Username = (EditText) findViewById(R.id.username_editText);
        Password = (EditText) findViewById(R.id.password_editText);
        Login = (Button) findViewById(R.id.login);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword){
        if ((userName.equals("clinic")) && (userPassword.equals("parivaar"))){
            //correct password

            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ClinicLogin.this, Menu.class);
            startActivity(intent);

            //add sender stuff
            Intent districtNameIntent = new Intent(ClinicLogin.this, intermediate.class);
            districtNameIntent.putExtra("DISTRICT_NAME_KEY", districtname.getText().toString().toUpperCase().trim());
            districtNameIntent.putExtra("CLINIC_NAME_KEY", clinicname.getText().toString().toUpperCase().trim());
            //start intermediate
            startActivity(districtNameIntent);
        }else{
            //wrong password
            Toast.makeText(this, "INCORRECT", Toast.LENGTH_SHORT).show();
        }
    }
}