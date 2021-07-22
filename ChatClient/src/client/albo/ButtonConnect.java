package client.albo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonConnect {
    private final JButton buttonConnect = new JButton("Connect");

    public void createSettings(JTextArea areaWithMessages, JTextField fieldForNickname) {
        final int[] countOfClicking = {0};
        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countOfClicking[0] == 0) {
                    MessagePoller poller = new MessagePoller(areaWithMessages);
                    PrivateMessagePoller privateMessagePoller = new PrivateMessagePoller(fieldForNickname, areaWithMessages);
                    Thread threadForPoller = new Thread(poller);
                    Thread threadForPrivateMessages = new Thread(privateMessagePoller);
                    threadForPoller.start();
                    threadForPrivateMessages.start();
                    fieldForNickname.setEditable(false);
                    countOfClicking[0] = countOfClicking[0] + 1;
                }
            }
        });
    }

    public JButton getButtonConnect() {
        return buttonConnect;
    }
}
