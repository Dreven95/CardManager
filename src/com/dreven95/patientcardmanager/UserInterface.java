package com.dreven95.patientcardmanager;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);

    public void startUserInterface() {
        String userAnswer;
        System.out.println("Здравствуйте! Выберете интересующую вас опцию: ");
        System.out.println("1. Создать карточку пациента \n 2. Удалить карточку пациента");
        userAnswer = scanner.nextLine();
        if (userAnswer.equals("1")) {
            PatientCard patient = new PatientCard("null", "null", "null");
            System.out.println("Введите имя пациента: ");
            patient.setPatientName(scanner.nextLine());
            System.out.println("Введите диагноз пациента: ");
            patient.setPatientDiagnosis(scanner.nextLine());
            System.out.println("Введите имя лечащего доктора: ");
            patient.setDoctorName(scanner.nextLine());
            Helper.writeToFile("database.txt", patient.toString());
            startUserInterface();
        }
        else if(userAnswer.equals("2")) {
            System.out.println("Введите id пациента");
            userAnswer = scanner.nextLine();
            Helper.readFile("database.txt");
            Helper.deleteToFile("database.txt", Integer.valueOf(userAnswer));
        }
    }
}
