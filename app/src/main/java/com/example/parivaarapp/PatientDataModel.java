package com.example.parivaarapp;

public class PatientDataModel {



    //Patient Attributes
    private String name;
    private String identificationNum;
    private String father_HusbandName;
    private int age;
    private int bloodPressure;
    private int weight;
    private int bodyTemp;
    private int bloodSugar;

    //Connected Doctors notes attributes
    private String doctorNote;
    private String doctorAdvice;
    private String medicinesUsed;
    private String followUpNeeded;
    private String needOfReferral;

    public PatientDataModel(){

    }

    public PatientDataModel(String name, String identificationNum, String father_HusbandName, int age, int bloodPressure, int weight, int bodyTemp, int bloodSugar, String doctorNote, String doctorAdvice, String medicinesUsed, String followUpNeeded, String needOfReferral) {
        this.identificationNum = identificationNum;
        this.father_HusbandName = father_HusbandName;
        this.age = age;
        this.bloodPressure = bloodPressure;
        this.weight = weight;
        this.bodyTemp = bodyTemp;
        this.bloodSugar = bloodSugar;
        this.doctorNote = doctorNote;
        this.doctorAdvice = doctorAdvice;
        this.medicinesUsed = medicinesUsed;
        this.followUpNeeded = followUpNeeded;
        this.needOfReferral = needOfReferral;
        this.name = name;
    }

    public String getIdentificationNum() {
        return identificationNum;
    }
//
    public void setIdentificationNum(String identificationNum) {
        this.identificationNum = identificationNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_HusbandName() {
        return father_HusbandName;
    }

    public void setFather_HusbandName(String father_HusbandName) {
        this.father_HusbandName = father_HusbandName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBodyTemp() {
        return bodyTemp;
    }

    public void setBodyTemp(int bodyTemp) {
        this.bodyTemp = bodyTemp;
    }

    public int getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(int bloodSugar) {
        this.bloodSugar = bloodSugar;
    }

    public String getDoctorNote() {
        return doctorNote;
    }

    public void setDoctorNote(String doctorNote) {
        this.doctorNote = doctorNote;
    }

    public String getDoctorAdvice() {
        return doctorAdvice;
    }

    public void setDoctorAdvice(String doctorAdvice) {
        this.doctorAdvice = doctorAdvice;
    }

    public String getMedicinesUsed() {
        return medicinesUsed;
    }

    public void setMedicinesUsed(String medicinesUsed) {
        this.medicinesUsed = medicinesUsed;
    }

    public String getFollowUpNeeded() {
        return followUpNeeded;
    }

    public void setFollowUpNeeded(String followUpNeeded) {
        this.followUpNeeded = followUpNeeded;
    }

    public String getNeedOfReferral() {
        return needOfReferral;
    }

    public void setNeedOfReferral(String needOfReferral) {
        this.needOfReferral = needOfReferral;
    }

}

