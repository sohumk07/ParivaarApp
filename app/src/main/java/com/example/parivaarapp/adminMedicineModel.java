package com.example.parivaarapp;

import com.google.firebase.firestore.DocumentId;

public class adminMedicineModel {

    private int quantity;
    private String lastRefilled;
    private String name;


    private adminMedicineModel(){}

    public adminMedicineModel(int quantity, String lastRefilled, String name) {
        this.quantity = quantity;
        this.lastRefilled = lastRefilled;
        this.name = name;
    }

    @DocumentId
    public String getName() {
        return name;
    }
    @DocumentId
    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLastRefilled() {
        return lastRefilled;
    }

    public void setLastRefilled(String lastRefilled) {
        this.lastRefilled = lastRefilled;
    }

}
