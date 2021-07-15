package client.albo;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MessagePoller implements Runnable {
    private String messages;
    JTextArea textArea;

    public MessagePoller(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void run() {
        int count = 0;
        try {
            while (true) {
                String message = "Сервер, хочу все сообщения!" + count;
                Socket socket = new Socket("localhost", 8888);
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.println(message);
                out.flush();
                while ((messages = in.readLine()) != null) {
                    if (!messages.equals("")) {
                        count++;
                        textArea.append(messages);
                        textArea.append("\n");
                    }
                }
                socket.close();
                Thread.sleep(100);
            }
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
    }

    private void inMessage() throws IOException {
        Socket socket = new Socket("localhost", 8888);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String words = in.readLine();
        System.out.println(words);
    }

    public String getMessages() {
        return messages;
    }
}