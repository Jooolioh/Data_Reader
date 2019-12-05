package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataReaderManager {
    private String fName;
    private static MessagesArray messagesArray;

    public DataReaderManager(String file) {
        fName = file;
    }

    public static void main(String[] args) {
        try {
            DataReaderManager dr = new DataReaderManager("out/production/Data_Reader/com/company/Log_temp.csv");
            int res = dr.readDataFromLog();
            System.out.println("Numero linee lette: " + res);
            messagesArray.printAllTest();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Errore File non trovato!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Errore IO!");
        }
    }

    public int readData() throws FileNotFoundException, IOException {
        File f = new File(this.fName);
        FileInputStream fis = new FileInputStream(f);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String linea = br.readLine();
        int count = 0;
        while(linea != null) {
            System.out.println(linea);
            linea = br.readLine();
            count++;
        }
        br.close();
        return count;
    }

    public int readDataFromLog() throws FileNotFoundException, IOException {
        messagesArray = new MessagesArray();


        File fin = new File(this.fName); //File input
        //Input Init
        FileInputStream fis = new FileInputStream(fin);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        //Reading Input File
        String linea = br.readLine();
        int countFile = 0;

        while (linea != null) {
            if (linea.startsWith("\"Time")){
                linea = br.readLine();
                countFile++;
                break;
            }
            linea = br.readLine();
            countFile++;
        }

        while (linea != null) {
            //TODO parametrizzare questi valori REGEDIT
            //System.out.print(linea);
            String id = linea.substring(16, 18);
            //System.out.print("Id: " + id);
            String time = linea.substring(1, 13);
            //System.out.print(" Time: " + time);
            String mex = linea.substring(30, 53).replace(" ", "");
            //System.out.println(" Mex: " + mex);
            messagesArray.addMessage(new BaseMessage(mex, id, time));

            linea = br.readLine();
            countFile++;
        }
        br.close();
        return countFile;
    }


}
