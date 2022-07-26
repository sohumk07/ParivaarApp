package com.example.parivaarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AdminPresetData extends AppCompatActivity {
    private RecyclerView mFirestoreList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_preset_data);


        mFirestoreList = findViewById(R.id.firestore_list);
    }
}