package com.example.parivaarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class adminmedicine extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoreList;

    private FirestoreRecyclerAdapter medicinesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmedicine);

        Intent receiverIntent = getIntent();
        String district = receiverIntent.getStringExtra("KEY_SENDER");

        //recycler view for medicines starts here//
        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.admin_listOfMedicines); //the actual recycler view


        //RecyclerOptions
        Query query = firebaseFirestore.collection("test medicine").document("medicines").collection("testDistrict").whereLessThan("quantity", 100).orderBy("quantity");

        FirestoreRecyclerOptions<adminMedicineModel> options = new FirestoreRecyclerOptions.Builder<adminMedicineModel>()
                .setQuery(query, adminMedicineModel.class)
                .build();


        medicinesAdapter = new FirestoreRecyclerAdapter<adminMedicineModel, adminmedicine.medicineDataHolder>(options) {
            @NonNull
            @Override
            public adminmedicine.medicineDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_medicine_items, parent, false);
                return new adminmedicine.medicineDataHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull adminmedicine.medicineDataHolder holder, int position, @NonNull adminMedicineModel model) {
                holder.name.setText(model.getName());
                holder.quantity.setText("Quantity: " + model.getQuantity());
                holder.lastRefilled.setText("Last refilled on: " + model.getLastRefilled());
                Log.d("tag", "the stuff has been set");
            }
        };

        mFirestoreList.setHasFixedSize(false);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(medicinesAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle(district);
        actionBar.setTitle("[ADMIN] Manage medicines");


    }

    private class medicineDataHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView quantity;
        private TextView lastRefilled;

        public medicineDataHolder(@NonNull View itemView) {
            super(itemView);
            quantity = itemView.findViewById(R.id.quantity);
            lastRefilled = itemView.findViewById(R.id.lastRefilled);
            name = itemView.findViewById(R.id.name);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        medicinesAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        medicinesAdapter.stopListening();
    }

    //code for top bar
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.Menu:
                startActivity(new Intent(adminmedicine.this, AdminMenu.class));
                break;

            case R.id.sign_out:
                startActivity(new Intent(adminmedicine.this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}