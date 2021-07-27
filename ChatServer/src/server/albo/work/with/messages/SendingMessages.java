package server.albo.work.with.messages;

import java.io.PrintWriter;

public class SendingMessages {

    public void sendMessagesToClient(MessageDataBase messageDataBase, String word, PrintWriter out) {
        String[] arrayOfWord = word.split("!");
        int count = Integer.parseInt(arrayOfWord[1]);
        String words = "";
        if (count != messageDataBase.getListOfMessages().size()) {
            for (int i = count; i < messageDataBase.getListOfMessages().size(); i++) {
                words = words + messageDataBase.getListOfMessages().get(i) + "\n";
            }
        }
        out.println(words);
        out.flush();
    }
}
