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

import com.google.android.material.textfield.TextInputEditText;

public class ClinicLogin extends AppCompatActivity {

    private EditText Password;
    private TextView Info;
    private Button Login;
    private EditText districtname;
    private EditText clinicname;

    public String district;
    public String clinicNum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic_login);


        districtname = findViewById(R.id.textView7);
        clinicname = findViewById(R.id.textView52);


//Code to change text of the toolbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle("App Name");
        actionBar.setTitle("Clinic Login Screen");
        actionBar.setDisplayHomeAsUpEnabled(true);


        Password = (EditText) findViewById(R.id.password_editText);
        Login = (Button) findViewById(R.id.login);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Password.getText().toString().equals("parivaar")){
                    Toast.makeText(ClinicLogin.this, "CORRECT", Toast.LENGTH_SHORT).show();

                    //sender intent
                    Intent intent = new Intent(ClinicLogin.this, Menu.class);
                    intent.putExtra("DISTRICT_NAME_KEY", districtname.getText().toString().toUpperCase().trim());
                    intent.putExtra("CLINIC_NAME_KEY", clinicname.getText().toString().toUpperCase().trim());
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ClinicLogin.this, "INCORRECT", Toast.LENGTH_SHORT).show();

                }
            }
        });




    }

}