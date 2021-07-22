package client.albo;

import javax.swing.*;

public class AreaWithMessages {
    private final JTextArea textArea = new JTextArea(15, 20);

    public JScrollPane createScrollPaneForArea() {
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
