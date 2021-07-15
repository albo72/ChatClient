package client.albo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientWindow {

    public void createFrame() {
        ClientHelper clientHelper = new ClientHelper();
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
        clientHelper.setGrid(gridBagConstraints, 0, 0, 0.9, 3, 300);
        panel.add(scrollPane, gridBagConstraints);
        JTextField textMessage = new JTextField();
        clientHelper.setGrid(gridBagConstraints, 0, 3, 0.9, 1, 10);
        panel.add(textMessage, gridBagConstraints);
        JTextField textNickname = new JTextField("Nickname");
        clientHelper.setGrid(gridBagConstraints, 1, 0, 0.1, 1, 10);
        panel.add(textNickname, gridBagConstraints);
        JButton buttonSend = new JButton("Send");
        buttonSend.setSize(40, 20);
        clientHelper.setGrid(gridBagConstraints, 1, 3, 0.1, 1, 0);
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientHelper.connectAndSendMessage(textNickname, textMessage);
            }
        });
        panel.add(buttonSend, gridBagConstraints);
        frame.add(panel);
        frame.setVisible(true);

        MessagePoller poller = new MessagePoller(textArea);
        Thread thread = new Thread(poller);
        thread.start();
    }


}
