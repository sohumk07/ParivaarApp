package com.example.parivaarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import java.text.SimpleDateFormat;
import java.util.Calendar;


public class adminmedicine extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore;
    private RecyclerView mFirestoreList;
    private FirestoreRecyclerAdapter medicineRecyclerAdapter;
    private static final String medicineTag = "medicine TAG";



    //Manage medicine
    private Button submitRefill;
    private EditText medicineQuantity;
    //autocomplete medicine name
    private AutoCompleteTextView medicineACTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmedicine);

        Intent receiverIntent = getIntent();
        String district = receiverIntent.getStringExtra("KEY_SENDER");

        //recycler view for medicines starts here//
        firebaseFirestore = FirebaseFirestore.getInstance();
        mFirestoreList = findViewById(R.id.admin_listOfMedicines); //the actual recycler view



        //Autocomplete code

        medicineACTV = findViewById(R.id.adminMedicineACTV);
        ArrayList<String> listOfMedicines = new ArrayList<String>();
        firebaseFirestore.collection("test medicine").document("medicines").collection(district)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                listOfMedicines.add(document.getId());
                                //Toast.makeText(DiagnoseIllness.this, document.getId(), Toast.LENGTH_SHORT).show();
                            }
                            ArrayAdapter<String> medicineAdapter = new ArrayAdapter<String>(adminmedicine.this, android.R.layout.simple_dropdown_item_1line, listOfMedicines);
                            medicineACTV.setAdapter(medicineAdapter);
                        } else {
                            Log.d(medicineTag, "Error getting documents: ", task.getException());
                        }
                    }
                });

        //RecyclerOptions
        Query query = firebaseFirestore.collection("test medicine").document("medicines").collection(district).whereLessThan("quantity", 100).orderBy("quantity");

        FirestoreRecyclerOptions<adminMedicineModel> options = new FirestoreRecyclerOptions.Builder<adminMedicineModel>()
                .setQuery(query, adminMedicineModel.class)
                .build();


        medicineRecyclerAdapter = new FirestoreRecyclerAdapter<adminMedicineModel, adminmedicine.medicineDataHolder>(options) {
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
            }
        };

        mFirestoreList.setHasFixedSize(false);
        mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
        mFirestoreList.setAdapter(medicineRecyclerAdapter);

        //Code to calculate medcine restock

        submitRefill = (Button) findViewById(R.id.submitRefill);
        medicineQuantity = findViewById(R.id.medicineQuantity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setSubtitle(district);
        actionBar.setTitle("[ADMIN] Manage medicines");



        submitRefill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar secondTimestamp = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String secondTimestampString = dateFormat.format(secondTimestamp.getTimeInMillis());



                if (TextUtils.isEmpty(medicineACTV.getText())) {
                    medicineACTV.setError("Cannot Be Empty");
                    return;
                }
                if (TextUtils.isEmpty(medicineQuantity.getText())) {
                    medicineQuantity.setError("Cannot Be Empty");
                    return;
                }

                String quantity = medicineQuantity.getText().toString().toUpperCase().trim();
                String medicineName = medicineACTV.getText().toString().trim();

                //TODO: replace "lastRefilled" with date (DONE)


                DocumentReference specificMedicine = firebaseFirestore.collection("test medicine").document("medicines").collection(district).document(medicineName);
                Map<String, Object> refillDocument = new HashMap<>();

                specificMedicine.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document.exists()) {
                                specificMedicine.update("quantity", FieldValue.increment(Integer.parseInt(quantity))); //TODO: implement something that allows you to increment if doc exist, if not create new doc
                                refillDocument.put("lastRefilled", secondTimestampString);



                            } else {
                                refillDocument.put("quantity", Integer.parseInt(quantity));
                                refillDocument.put("lastRefilled", secondTimestampString);

                            }


                            firebaseFirestore.collection("test medicine").document("medicines").collection(district).document(medicineName)
                                    .set(refillDocument, SetOptions.merge())
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Log.d(medicineTag, "DocumentSnapshot successfully written!");
                                            Toast.makeText(adminmedicine.this, "Refill processed to database on " + secondTimestampString, Toast.LENGTH_SHORT).show();
                                            medicineQuantity.getText().clear();
                                            medicineACTV.getText().clear();
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.w(medicineTag, "Error writing document", e);
                                            Toast.makeText(adminmedicine.this, "Refill processed to database on " + secondTimestampString, Toast.LENGTH_SHORT).show();
                                        }
                                    });



                        }


                    }


                });





            }


        });
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
        medicineRecyclerAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        medicineRecyclerAdapter.stopListening();
    }

    //code for top bar
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //TODO: remove inflater so that there are no menu buttons and stuff
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