package server.albo;

import java.util.ArrayList;
import java.util.List;

public class MessageSaver {
    private List<String> listOfMessages = new ArrayList<>();

    public List<String> getListOfMessages() {
        return listOfMessages;
    }

    public void addToMessages (String message){
        this.listOfMessages.add(message);
    }
}
