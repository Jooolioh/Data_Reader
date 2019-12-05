package com.company;

import java.util.ArrayList;
import java.util.List;

public class MessagesArray {

    private List<BaseMessage> messages = new ArrayList<>();

    public MessagesArray() {}

    public void addMessage( BaseMessage msg ){
        messages.add(msg);
    }

    public List<DataSetMessage> getMessages( String ID, int bitStart, int bitFinish ){
        List<DataSetMessage> outList = new ArrayList<>();
        for (BaseMessage msg : messages){
            if ( msg.ID.equalsIgnoreCase(ID) ){
                outList.add(new DataSetMessage(msg.ID, msg.getMexBinary().substring(bitStart, bitFinish), msg.time));
            }
        }
        return outList;
    }

    public void printAllTest(){
        for (BaseMessage msg : messages){
            System.out.println(msg.toString());
        }
    }


}
