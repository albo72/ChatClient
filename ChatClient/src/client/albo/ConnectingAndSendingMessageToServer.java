package client.albo;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectingAndSendingMessageToServer {

    public void connectAndSendMessage(JTextField textNickname, JTextField textMessage) {
        int serverPort = 8888;
        String serverHost = "localhost";
        Socket clientSocket;
        if (!textNickname.getText().trim().isEmpty() && !textMessage.getText().trim().isEmpty()) {
            String message = textNickname.getText() + ": " + textMessage.getText();
            try {
                clientSocket = new Socket(serverHost, serverPort);
                PrintWriter outMessage = new PrintWriter(clientSocket.getOutputStream());
                outMessage.write(message);
                outMessage.flush();
                clientSocket.close();
                textMessage.selectAll();
                textMessage.replaceSelection(null);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
