package com.example.parivaarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class intermediate extends AppCompatActivity {
    private Button button;
    private EditText enterID;
    String districtName;
    String clinicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);

        // doctors note
        Intent menuIntent = getIntent();
        districtName = menuIntent.getStringExtra("DISTRICT_NAME_KEY");
        clinicName = menuIntent.getStringExtra("CLINIC_NAME_KEY");

        button=findViewById(R.id.button);
        enterID = findViewById(R.id.enterID);

//        public void buttonSenderPressed(View v){
//            Intent senderIntent = new Intent(this, DiagnoseIllness.class);
//            senderIntent.putExtra("KEY_SENDER", Integer.parseInt(patientID.getText().trim());
//        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Enter patient ID");
        actionBar.setSubtitle(districtName + ", Clinic #:" + clinicName);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO uncomment when testing is complete
//                if(!(enterID.getText().toString().length() == 12 )){
//                    //code if not valid ID
//                    enterID.setError("Not a valid AADHAR number (12 digits)");
//                    //Toast.makeText(intermediate.this, "Not a valid AADHAR number, please try again", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                //code
                Intent senderIntent = new Intent(intermediate.this, DiagnoseIllness.class);
                senderIntent.putExtra("KEY_PATIENT", enterID.getText().toString().trim());
                senderIntent.putExtra("DISTRICT_NAME_KEY", districtName);
                senderIntent.putExtra("CLINIC_NAME_KEY", clinicName);
                startActivity(senderIntent);


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
                Intent districtNameIntent = new Intent(intermediate.this, com.example.parivaarapp.Menu.class);

//
                districtNameIntent.putExtra("DISTRICT_NAME_KEY", districtName);
                districtNameIntent.putExtra("CLINIC_NAME_KEY", clinicName);
                //start intermediate
                startActivity(districtNameIntent);                break;
            case R.id.sign_out:
                startActivity(new Intent(intermediate.this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}