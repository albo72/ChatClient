package client.albo;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class MessagePoller implements Runnable {
    private JTextArea textArea;

    public MessagePoller(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void run() {
        String messages;
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
                        textArea.append(messages + "\n");
                    }
                }
                socket.close();
                Thread.sleep(300);
            }
        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }
    }
}
