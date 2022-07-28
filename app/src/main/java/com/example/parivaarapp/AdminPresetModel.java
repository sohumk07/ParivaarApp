package com.example.parivaarapp;

public class AdminPresetModel {

    private String clinicName;
    private String doctorName;
    private String driverName;
    private String attendantName;

    private AdminPresetModel(){

    }

    private AdminPresetModel(String doctorName, String driverName, String attendantName) {
        this.doctorName = doctorName;
        this.driverName = driverName;
        this.attendantName = attendantName;
    }

    //getters
    public String getClinicName() {
        return clinicName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getAttendantName() {
        return attendantName;
    }

   // setters
    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setAttendantName(String attendantName) {
        this.attendantName = attendantName;
    }


}
