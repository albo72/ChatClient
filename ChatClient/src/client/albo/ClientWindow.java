package client.albo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientWindow {
    public final static int serverPort = 8888;
    public final static String serverHost = "localhost";
    private Socket clientSocket;
    private PrintWriter outMessage;


    public void createFrame() {
        JFrame frame = new JFrame("Chat");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JTextArea textArea = new JTextArea(200, 500);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        setGrid(gridBagConstraints, 0, 0, 0.9, 3, 300);
        panel.add(scrollPane, gridBagConstraints);
        JTextField textMessage = new JTextField();
        setGrid(gridBagConstraints, 0, 3, 0.9, 1, 10);
        panel.add(textMessage, gridBagConstraints);
        JTextField textNickname = new JTextField("Nickname");
        setGrid(gridBagConstraints, 1, 0, 0.1, 1, 10);
        panel.add(textNickname, gridBagConstraints);
        JButton buttonSend = new JButton("Send");
        buttonSend.setSize(40, 20);
        setGrid(gridBagConstraints, 1, 3, 0.1, 1, 0);
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });
        panel.add(buttonSend, gridBagConstraints);

        frame.add(panel);
        frame.setVisible(true);
        MessagePoller poller = new MessagePoller(textArea);
        Thread thread = new Thread(poller);
        thread.start();
    }

    private void setGrid(GridBagConstraints gridBagConstraints, int i, int i2, double v, int i3, int i4) {
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.gridx = i;
        gridBagConstraints.gridy = i2;
        gridBagConstraints.weightx = v;
        gridBagConstraints.gridheight = i3;
        gridBagConstraints.ipady = i4;
    }


}
