package com.company;

public class DataSetMessage {
    String ID;
    float time;
    String value;

    public DataSetMessage(String ID, String value, float time) {
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

    public float getTime() {
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
