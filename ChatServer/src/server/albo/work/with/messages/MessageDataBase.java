package server.albo.work.with.messages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDataBase {
    private final List<String> listOfMessages = new ArrayList<>();
    private final Map<String, List<String>> privateMessages = new HashMap<>();

    public List<String> getListOfMessages() {
        return listOfMessages;
    }

    public Map<String, List<String>> getPrivateMessages() {
        return privateMessages;
    }

    public void saveMessage(String message) {
        this.listOfMessages.add(message);
    }
}
