package server.albo;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private final List<String> listOfMessages = new ArrayList<>();

    public List<String> getListOfMessages() {
        return listOfMessages;
    }

    public void saveMessage(String message) {
        this.listOfMessages.add(message);
    }
}
