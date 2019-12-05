package com.company;

public class BaseMessage {
    protected String mex;
    protected String ID;
    protected float time;
    protected int dataLength;

    public BaseMessage( String mex, String ID, float time, int dataLength ) {
        this.mex = mex;
        this.ID = ID;
        this.time = time;
        this.dataLength = dataLength;
    }

    public String getMexBinary() {
        //Long tmp = Long.parseLong(mex,16);
        //return Long.toString(tmp, 2);
        return convertHexToBin(mex);
    }

    private String convertHexToBin(String hexStr) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < hexStr.length(); i++) {
            int j = Character.digit(hexStr.toLowerCase().charAt(i), 16);
            str.append(hexBits[j]);
        }
        return str.toString();
    }

    public String getID() {
        return ID;
    }

    public float getTime() {
        return time;
    }

    public int getDataLength() {
        return dataLength;
    }

    public String getParam(int bitStart, int bitFinish ) {
        return mex.substring(bitStart, bitFinish);
    }

    @Override
    public String toString() {
        return "BaseMessage{" +
                "mex='" + getMexBinary() + '\'' +
                ", ID='" + ID + '\'' +
                ", time=" + time +
                ", dataLength=" + dataLength +
                '}';
    }

    private final String[] hexBits = {
            "0000", "0001", "0010", "0011",
            "0100", "0101", "0110", "0111",
            "1000", "1001", "1010", "1011",
            "1100", "1101", "1110", "1111"
    };
}
