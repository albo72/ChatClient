package client.albo;

import javax.swing.*;

public class ClientWindow {

    public void createFrame() {
        JFrame frame = new JFrame("Chat");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        panel.addComponentsOnPanel();
        frame.add(panel.getPanel());
        frame.setVisible(true);
    }
}
