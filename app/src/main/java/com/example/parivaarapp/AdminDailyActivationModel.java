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

    public AdminDailyActivationModel(String clinicName, String date, String doctorName, String attendantName, String driverName, String districtsVisited, String startMileage, String endMileage, String distanceTraveled, String getDistanceTraveled) {
        this.clinicName = clinicName;
        this.date = date;
        this.doctorName = doctorName;
        this.attendantName = attendantName;
        this.driverName = driverName;
        this.districtsVisited = districtsVisited;
        this.startMileage = startMileage;
        this.endMileage = endMileage;
        this.distanceTraveled = distanceTraveled;
        this.distanceTraveled = getDistanceTraveled;
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


    public String getDistanceTraveled() {return distanceTraveled;}

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


