package client.albo;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHelper {
    public final static int serverPort = 8888;
    public final static String serverHost = "localhost";
    private Socket clientSocket;
    private PrintWriter outMessage;

    public void connectAndSendMessage(JTextField textNickname, JTextField textMessage) {
        if (!textNickname.getText().trim().isEmpty() && !textMessage.getText().trim().isEmpty()) {
            String message = textNickname.getText() + ": " + textMessage.getText();
            try {
                clientSocket = new Socket(serverHost, serverPort);
                outMessage = new PrintWriter(clientSocket.getOutputStream());
                outMessage.write(message);
                outMessage.flush();
                clientSocket.close();
                textMessage.selectAll();
                textMessage.replaceSelection("");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public void setGrid(GridBagConstraints gridBagConstraints, int i, int i2, double v, int i3, int i4) {
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.gridx = i;
        gridBagConstraints.gridy = i2;
        gridBagConstraints.weightx = v;
        gridBagConstraints.gridheight = i3;
        gridBagConstraints.ipady = i4;
    }
}
