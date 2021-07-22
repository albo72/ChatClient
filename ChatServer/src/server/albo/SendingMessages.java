package server.albo;

import java.io.PrintWriter;

public class SendingMessages {

    public void sendMessagesToClient(Message message, String word, PrintWriter out) {
        String[] arrayOfWord = word.split("!");
        int count = Integer.parseInt(arrayOfWord[1]);
        String words = "";
        if (count != message.getListOfMessages().size()) {
            for (int i = count; i < message.getListOfMessages().size(); i++) {
                words = words + message.getListOfMessages().get(i) + "\n";
            }
        }
        out.println(words);
        out.flush();
    }
}
