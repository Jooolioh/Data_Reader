package com.company;

public class DataSetMessage {
    String ID;
    String time;
    String value;

    public DataSetMessage(String ID, String value, String time) {
        this.ID = ID;
        this.time = time;
        this.value = value;
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
                ", time=" + time +
                ", value='" + getDecValue() + '\'' +
                '}';
    }
}
