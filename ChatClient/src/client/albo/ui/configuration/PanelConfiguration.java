package client.albo.ui.configuration;

import javax.swing.*;
import java.awt.*;

public class PanelConfiguration {

    public void configurate(JPanel panel) {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        GridSettings gridSettings = new GridSettings();

        JTextArea textArea = new JTextArea(15, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        ConfigurationOfArea configurationOfArea = new ConfigurationOfArea();
        configurationOfArea.configurateAreaForMessages(textArea,scrollPane);
        gridSettings.changeGridSettings(gridBagConstraints, 0, 0, 0.9, 3, 300);
        panel.add(scrollPane, gridBagConstraints);

        JTextField fieldForMessage = new JTextField("Enter your message");
        ConfigurationOfFieldForMessage configurationOfFieldForMessage = new ConfigurationOfFieldForMessage();
        configurationOfFieldForMessage.configurate(fieldForMessage);
        gridSettings.changeGridSettings(gridBagConstraints, 0, 3, 0.9, 1, 10);
        panel.add(fieldForMessage, gridBagConstraints);

        JTextField fieldForNickname = new JTextField("Nickname");
        ConfigurationOfFieldForNickname configurationOfFieldForNickname = new ConfigurationOfFieldForNickname();
        configurationOfFieldForNickname.configurate(fieldForNickname);
        gridSettings.changeGridSettings(gridBagConstraints, 1, 0, 0.1, 1, 10);
        panel.add(fieldForNickname, gridBagConstraints);

        JButton buttonSend = new JButton("Send");
        ConfigurationOfButtonSend configurationOfButtonSend = new ConfigurationOfButtonSend();
        configurationOfButtonSend.configurate(fieldForNickname, fieldForMessage,buttonSend);
        gridSettings.changeGridSettings(gridBagConstraints, 1, 3, 0.1, 1, 0);
        panel.add(buttonSend, gridBagConstraints);

        JButton buttonConnect = new JButton("Connect");
        ConfigurationOfButtonConnect configurationOfButtonConnect = new ConfigurationOfButtonConnect();
        configurationOfButtonConnect.configurate(buttonConnect, textArea, fieldForNickname);
        gridSettings.changeGridSettings(gridBagConstraints, 1, 1, 0.1, 1, 0);
        panel.add(buttonConnect, gridBagConstraints);
    }
}
