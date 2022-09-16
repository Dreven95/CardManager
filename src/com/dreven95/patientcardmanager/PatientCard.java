package com.dreven95.patientcardmanager;

import java.util.Scanner;

public class PatientCard {

    private int patientId;
    private String patientName;
    private String diagnosis;
    private String doctorName;

    Scanner keyboard = new Scanner(System.in);
    private static int counter = 0;

    public void addPatientCard() {
        System.out.println("Введите имя пациента: ");
        this.patientName = keyboard.nextLine();
        System.out.println("Введите диагноз пациента: ");
        this.diagnosis = keyboard.nextLine();
        System.out.println("Введите имя лечащего доктора: ");
        this.doctorName = keyboard.nextLine();
        this.patientId = counter++;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDiagnosis() {
        return diagnosis;
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
                ", diagnosis='" + diagnosis + '\'' +
                ", doctorName='" + doctorName + '\'' +
                '}';
    }
}
