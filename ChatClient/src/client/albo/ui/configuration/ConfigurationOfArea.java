package client.albo.ui.configuration;

import javax.swing.*;

public class ConfigurationOfArea {

    public void configurateAreaForMessages(JTextArea textArea, JScrollPane scrollPane) {
        textArea.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

}
