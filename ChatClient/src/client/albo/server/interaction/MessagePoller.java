package client.albo.server.interaction;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class MessagePoller implements Runnable {
    private final JTextArea textArea;
    private JTextField textField;

    public MessagePoller(JTextArea textArea, JTextField textField) {
        this.textArea = textArea;
        this.textField = textField;
    }

    @Override
    public void run() {
        CountOfMessages countOfMessages = new CountOfMessages(0);
        CountOfMessages countOfPrivateMessages = new CountOfMessages(0);
        MessagesGeneration messagesGeneration = new MessagesGeneration();
        try {
            while (true) {
                String message = "Сервер, хочу все сообщения!" + countOfMessages.getCount();
                connectAndGenerateMessages(messagesGeneration, countOfMessages, message, "");
                String privateMessage = "/private " + textField.getText() + " " + countOfPrivateMessages.getCount();
                connectAndGenerateMessages(messagesGeneration, countOfPrivateMessages, privateMessage, "private message from ");
                Thread.sleep(300);
            }
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
    }

    private void connectAndGenerateMessages(MessagesGeneration messagesGeneration, CountOfMessages countOfMessages, String messageOut, String extraString) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println(messageOut);
        out.flush();
        messagesGeneration.generateMessages(socket, extraString, countOfMessages, textArea);
        socket.close();
    }
}


