package server.albo;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class SendingPrivateMessages {

    public void sendPrivateMessagesToClient(Map<String, List<String>> map, String word, PrintWriter out) {
        String words = "";
        String[] array = word.split(" ");
        String nickname = array[1];
        int count = Integer.parseInt(array[2]);
        if (map.containsKey(nickname)) {
            if (count != map.get(nickname).size()) {
                for (int i = count; i < map.get(nickname).size(); i++) {
                    words = words + map.get(nickname).get(i) + "\n";
                }
            }
        }
        out.println(words);
        out.flush();
    }
}
