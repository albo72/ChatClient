package server.albo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrivateMessage {
    private final Map<String, List<String>> privateMessages = new HashMap<>();

    public Map<String, List<String>> getPrivateMessages() {
        return privateMessages;
    }
}
