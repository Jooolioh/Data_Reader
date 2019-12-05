package com.company;

public class BaseMessage {
    protected String mex;
    protected String ID;
    protected String time;

    public BaseMessage( String mex, String ID, String time ) {
        this.mex = mex;
        this.ID = ID;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public String getParam(int bitStart, int bitFinish ) {
        return getMexBinary().substring(bitStart, bitFinish);
    }

    private final String[] hexBits = {
            "0000", "0001", "0010", "0011",
            "0100", "0101", "0110", "0111",
            "1000", "1001", "1010", "1011",
            "1100", "1101", "1110", "1111"
    };

    @Override
    public String toString() {
        return "BaseMessage{" +
                "mex='" + getMexBinary() + '\'' +
                ", ID='" + ID + '\'' +
                ", time=" + time +
                '}';
    }
}
