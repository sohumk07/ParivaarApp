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

public class MasterLogin extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView Info;
    private Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_login);

        Username = (EditText) findViewById(R.id.username_editText);
        Password = (EditText) findViewById(R.id.password_editText);
        Login = (Button) findViewById(R.id.login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Admin Login Screen");
        actionBar.setSubtitle("App Name");

        actionBar.setDisplayHomeAsUpEnabled(true);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Username.getText().toString(), Password.getText().toString());

            }
        });

    }

    private void validate(String userName, String userPassword){
        if ((userName.equals("admin")) && (userPassword.equals("parivaar"))){
            //correct password
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MasterLogin.this, AdminMenu.class);
            startActivity(intent);
        }else{
            //wrong password
            Toast.makeText(this, "INCORRECT", Toast.LENGTH_SHORT).show();


        }
    }
}