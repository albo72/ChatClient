package client.albo;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PrivateMessagePoller implements Runnable {
    private JTextField textField;
    private JTextArea textArea;

    public PrivateMessagePoller(JTextField textField, JTextArea textArea) {
        this.textField = textField;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        int count = 0;
        String messages;
        try {
            while (true) {
                if (!textField.getText().trim().isEmpty() & !textField.isEditable()) {
                    String message = "/private " + textField.getText() + " " + count;
                    Socket socket = new Socket("localhost", 8888);
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out.println(message);
                    out.flush();
                    while ((messages = in.readLine()) != null) {
                        if (!messages.equals("")) {
                            count++;
                            String privateMessage = "private message from " + messages;
                            textArea.append(privateMessage + "\n");
                        }
                    }
                    socket.close();
                    Thread.sleep(320);
                }
            }
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
    }
}
