package com.example.parivaarapp;

public class AdminDailyActivationModel {
    private String clinicName;
    private String date;

    private String doctorName;
    private String attendantName;
    private String driverName;
    private String districtsVisited;
    private String startMileage;
    private String endMileage;
    private String distanceTraveled;

    private AdminDailyActivationModel() {

    }

    private AdminDailyActivationModel(String doctorName, String driverName, String attendantName) {
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

    public String getDate() {
        return date;
    }

    public String getDistrictsVisited() {
        return districtsVisited;
    }

    public String getStartMileage() {
        return startMileage;
    }

    public String getEndMileage() {
        return endMileage;
    }

    public String getDistanceTraveled() {
        return distanceTraveled;
    }
    // setters


    public void setDate(String date) {
        this.date = date;
    }

    public void setDistrictsVisited(String districtsVisited) {
        this.districtsVisited = districtsVisited;
    }

    public void setStartMileage(String startMileage) {
        this.startMileage = startMileage;
    }

    public void setEndMileage(String endMileage) {
        this.endMileage = endMileage;
    }

    public void setDistanceTraveled(String distanceTraveled) {
        this.distanceTraveled = distanceTraveled;


    }


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


