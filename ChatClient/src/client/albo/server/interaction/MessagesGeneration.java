package client.albo.server.interaction;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessagesGeneration {
    public void generateMessages(Socket socket, String extraString, CountOfMessages countOfMessages, JTextArea textArea) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String messageIn;
        while ((messageIn = in.readLine()) != null) {
            if (!messageIn.equals("")) {
                countOfMessages.enlargeCount();
                textArea.append(extraString + messageIn + "\n");
            }
        }
    }
}
