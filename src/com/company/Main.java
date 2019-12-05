package com.company;

public class Main {
    public static void main(String[] args){
        DataReaderManager drm = new DataReaderManager("src/com/company/Log_temp.csv");
        drm.readFile();

        drm.getMessagesArray();
    }
}
