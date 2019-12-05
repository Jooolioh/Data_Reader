package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class DataReaderManager {
    private String fName;
    private static MessagesArray messagesArray;

    public DataReaderManager(String file) {
        fName = file;
    }

    public static void main(String[] args) {
        try {
            DataReaderManager dr = new DataReaderManager("/Users/giulio/Desktop/Data_Reader/src/com/company/data_test.trc");
            int res = dr.readDataFromTRC();
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

    public int readDataFromTRC() throws FileNotFoundException, IOException {
        messagesArray = new MessagesArray();


        File fin = new File(this.fName); //File input
        //Input Init
        FileInputStream fis = new FileInputStream(fin);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        //Reading Input File
        String linea = br.readLine();
        int countFile = 0, cOut = 0;
        while (linea != null) {
            if (linea.charAt(0) != ';') {
                //System.out.println(linea);
                //TODO parametrizzare questi valori REGEDIT
                //System.out.println(linea);
                String id = linea.substring(32, 36);
                //System.out.println(id);
                String time = linea.substring(10, 20);
                //System.out.println(time);
                String dtLength = linea.substring(38, 39);
                //System.out.println(dtLength);
                String mex = linea.substring(41, 64).replace(" ", "");
                //System.out.println(mex);

                messagesArray.addMessage(new BaseMessage(mex, id, Float.parseFloat(time), Integer.parseInt(dtLength)));
            }
            linea = br.readLine();
            countFile++;
        }
        br.close();
        return countFile;
    }


}
