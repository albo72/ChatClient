package server.albo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Server {

    private static final int port = 8888;
    private BufferedReader in;
    private PrintWriter out;

    public Server() {
        Socket clientSocket = null;
        ServerSocket serverSocket = null;
        MessageSaver messageSaver = new MessageSaver();
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен");
            while (true) {
                clientSocket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream());
                String word = in.readLine();
                Pattern pattern = Pattern.compile("Сервер, хочу все сообщения!.");
                Matcher matcher = pattern.matcher(word);
                if (matcher.find()) {
                    String[] arrayOfWord = word.split("!");
                    int count = Integer.parseInt(arrayOfWord[1]);
                    String words = "";
                    if (count != messageSaver.getListOfMessages().size()) {
                        for (int i = count; i < messageSaver.getListOfMessages().size(); i++) {
                            words = words + messageSaver.getListOfMessages().get(i) + "\n";
                        }
                    }
                    out.println(words);
                    out.flush();
                } else {
                    messageSaver.addToMessages(word);
                }
                out.close();
                in.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}

