package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataSetMessage {
    private String ID;
    private String time;
    private Date timeParsed;
    private String value;
    private DateFormat sdf = new SimpleDateFormat("hh:mm:ss.SSS");

    public DataSetMessage(String ID, String value, String time) {
        this.ID = ID;
        this.time = time;
        this.value = value;
        convertTime();
    }

    public void convertTime(){
        try{
            timeParsed = sdf.parse(time);
            System.out.println(timeParsed);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date getTimeParsed() {
        return timeParsed;
    }

    public String getID() {
        return ID;
    }

    public String getValue() {
        return value;
    }

    public String getDecValue(){
        return String.valueOf(Long.parseLong(value,16));
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "DataSetMessage{" +
                "ID='" + ID + '\'' +
                ", time=" + sdf.format(timeParsed) +
                ", value='" + value + '\'' +
                '}';
    }
}
