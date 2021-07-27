package client.albo.ui.configuration;

import javax.swing.*;

public class ClientWindow {

    public void createFrame() {
        JFrame frame = new JFrame("Chat");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        PanelConfiguration panelConfiguration = new PanelConfiguration();
        panelConfiguration.configurate(panel);
        frame.add(panel);
        frame.setVisible(true);
    }
}
