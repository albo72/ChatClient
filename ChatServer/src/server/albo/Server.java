package server.albo;

import server.albo.work.with.messages.MessageDataBase;
import server.albo.work.with.messages.PrivateMessagesSaving;
import server.albo.work.with.messages.SendingMessages;
import server.albo.work.with.messages.SendingPrivateMessages;

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
        MessageDataBase messageDataBase = new MessageDataBase();
        PrivateMessagesSaving privateMessagesSaving = new PrivateMessagesSaving();
        SendingMessages sendingMessages = new SendingMessages();
        SendingPrivateMessages sendingPrivateMessages = new SendingPrivateMessages();

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен");
            while (true) {
                clientSocket = serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream());
                String word = in.readLine();
                Pattern patternForPoller = Pattern.compile("Сервер, хочу все сообщения!.");
                Matcher matcherForPoller = patternForPoller.matcher(word);
                Pattern patternForPrivate = Pattern.compile(".+\s/p\s.+");
                Matcher matcherForPrivate = patternForPrivate.matcher(word);
                Pattern patternGetPrivate = Pattern.compile("/private\s.+");
                Matcher matcherGetPrivate = patternGetPrivate.matcher(word);
                if (matcherForPoller.find()) {
                    sendingMessages.sendMessagesToClient(messageDataBase, word, out);
                } else if (matcherForPrivate.find()) {
                    privateMessagesSaving.savePrivateMessage(messageDataBase.getPrivateMessages(), word);
                } else if (matcherGetPrivate.find()) {
                    sendingPrivateMessages.sendPrivateMessagesToClient(messageDataBase, word, out);
                } else {
                    messageDataBase.saveMessage(word);
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

