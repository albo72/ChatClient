package server.albo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrivateMessagesSaving {

    public void savePrivateMessage(Map<String, List<String>> map, String word) {
        String[] arrayOfPrivateMessage = word.split(" ");
        String privateMessage = arrayOfPrivateMessage[0] + " ";
        for (int i = 3; i < arrayOfPrivateMessage.length; i++) {
            privateMessage = privateMessage + " " + arrayOfPrivateMessage[i];
        }
        if (map.containsKey(arrayOfPrivateMessage[2])) {
            map.get(arrayOfPrivateMessage[2]).add(privateMessage);
        } else {
            List<String> privates = new ArrayList<>();
            privates.add(privateMessage);
            map.put(arrayOfPrivateMessage[2], privates);
        }
    }
}
