package server.albo.work.with.messages;

import java.io.PrintWriter;

public class SendingPrivateMessages {

    public void sendPrivateMessagesToClient(MessageDataBase messageDataBase, String word, PrintWriter out) {
        String words = "";
        String[] array = word.split(" ");
        String nickname = array[1];
        int count = Integer.parseInt(array[2]);
        if (messageDataBase.getPrivateMessages().containsKey(nickname)) {
            if (count != messageDataBase.getPrivateMessages().get(nickname).size()) {
                for (int i = count; i < messageDataBase.getPrivateMessages().get(nickname).size(); i++) {
                    words = words + messageDataBase.getPrivateMessages().get(nickname).get(i) + "\n";
                }
            }
        }
        out.println(words);
        out.flush();
    }
}
