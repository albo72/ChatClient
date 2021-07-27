package client.albo.ui.configuration;

import client.albo.server.interaction.ConnectingAndSendingMessageToServer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigurationOfButtonSend {

    public void configurate(JTextField textNickname, JTextField textMessage, JButton buttonSend) {
        ConnectingAndSendingMessageToServer connectingAndSendingMessageToServer = new ConnectingAndSendingMessageToServer();
        buttonSend.setSize(40, 20);
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectingAndSendingMessageToServer.connectAndSendMessage(textNickname, textMessage);
            }
        });
    }
}
