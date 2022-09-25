package com.dreven95.patientcardmanager;


public class PatientCard {

    private int patientId;
    private String patientName;
    private String patientDiagnosis;
    private String doctorName;

    private static int counter = 0;

    public PatientCard(String patientName, String patientDiagnosis, String doctorName) {
        this.patientName = patientName;
        this.patientDiagnosis = patientDiagnosis;
        this.doctorName = doctorName;
        this.patientId = counter++;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientDiagnosis(String patientDiagnosis) {
        this.patientDiagnosis = patientDiagnosis;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientDiagnosis() {
        return patientDiagnosis;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public int getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return "PatientCard{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientDiagnosis='" + patientDiagnosis + '\'' +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}
