package com.dreven95.patientcardmanager;
import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private String answer;
    Scanner keyboard = new Scanner(System.in);

    public void UI() {
        System.out.println("Здравствуйте! Выберете интересующую вас опцию: ");
        System.out.println("1. Создать карточку пациента \n 2. Удалить карточку пациента");
        this.answer = keyboard.nextLine();
        if (this.answer.equals("1")) {
            PatientCard patient = new PatientCard();
            patient.addPatientCard();
            writeToFile("database.txt", patient.toString());
            UI();
        }
        else if(this.answer.equals("2")) {
            System.out.println("Введите id пациента");
            this.answer = keyboard.nextLine();
            readFile("database.txt");
            deleteToFile("database.txt", Integer.valueOf(this.answer));
        }
    }

    private static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content + "&" + "\n");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readFile(String fileName) {
        String str = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while(reader.ready()) {
                str += reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }

    private static void deleteToFile(String fileName, int patientId) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("temp.txt"))) {
            String[] strArray = readFile(fileName).split("&");
            for (int i = 0; i < strArray.length; i++) {
                if(!(strArray[i].contains("patientId=" + Integer.toString(patientId)))) {
                    writer.write(strArray[i] + "&" + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt"))) {
            String[] strArray = readFile("temp.txt").split("&");
            for (int i = 0; i < strArray.length; i++) {
                writer.write(strArray[i] + "&" + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
