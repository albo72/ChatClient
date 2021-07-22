package client.albo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSend {
    private final JButton buttonSend = new JButton("Send");

    public void createSettings(JTextField textNickname, JTextField textMessage) {
        ConnectingAndSendingMessageToServer connectingAndSendingMessageToServer = new ConnectingAndSendingMessageToServer();
        buttonSend.setSize(40, 20);
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectingAndSendingMessageToServer.connectAndSendMessage(textNickname, textMessage);
            }
        });
    }

    public JButton getButtonSend() {
        return buttonSend;
    }
}
