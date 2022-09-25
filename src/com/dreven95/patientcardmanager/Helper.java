package com.dreven95.patientcardmanager;

import java.io.*;

public class Helper {

    static void writeToFile(String fileName, String content) {
        File inputFile = new File(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile, true))) {
            writer.write(content + "&" + "\n");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String readFile(String fileName) {
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

    static void deleteToFile(String fileName, int patientId) {
        File tempFile = new File("temp.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String[] strArray = readFile(fileName).split("&");
            for (int i = 0; i < strArray.length; i++) {
                if(!(strArray[i].contains("patientId=" + Integer.toString(patientId)))) {
                    writer.write(strArray[i] + "&" + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tempFile.renameTo(new File("database.txt"));
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt"))) {
//            String[] strArray = readFile("temp.txt").split("&");
//            for (int i = 0; i < strArray.length; i++) {
//                writer.write(strArray[i] + "&" + "\n");
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
