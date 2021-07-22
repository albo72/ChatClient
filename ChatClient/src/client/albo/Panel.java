package client.albo;

import javax.swing.*;
import java.awt.*;

public class Panel {
    private final JPanel panel = new JPanel();

    public void addComponentsOnPanel() {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        GridSettings gridSettings = new GridSettings();
        AreaWithMessages areaWithMessages = new AreaWithMessages();
        areaWithMessages.createScrollPaneForArea();
        gridSettings.changeGridSettings(gridBagConstraints, 0, 0, 0.9, 3, 300);
        panel.add(areaWithMessages.createScrollPaneForArea(), gridBagConstraints);
        FieldForMessage fieldForMessage = new FieldForMessage();
        fieldForMessage.createFieldSettings();
        gridSettings.changeGridSettings(gridBagConstraints, 0, 3, 0.9, 1, 10);
        panel.add(fieldForMessage.getFieldForMessage(), gridBagConstraints);
        FieldForNickname fieldForNickname = new FieldForNickname();
        fieldForNickname.createFieldSettings();
        gridSettings.changeGridSettings(gridBagConstraints, 1, 0, 0.1, 1, 10);
        panel.add(fieldForNickname.getFieldForNickname(), gridBagConstraints);
        ButtonSend buttonSend = new ButtonSend();
        buttonSend.createSettings(fieldForNickname.getFieldForNickname(), fieldForMessage.getFieldForMessage());
        gridSettings.changeGridSettings(gridBagConstraints, 1, 3, 0.1, 1, 0);
        panel.add(buttonSend.getButtonSend(), gridBagConstraints);
        ButtonConnect buttonConnect = new ButtonConnect();
        buttonConnect.createSettings(areaWithMessages.getTextArea(), fieldForNickname.getFieldForNickname());
        gridSettings.changeGridSettings(gridBagConstraints, 1, 1, 0.1, 1, 0);
        panel.add(buttonConnect.getButtonConnect(), gridBagConstraints);
    }

    public JPanel getPanel() {
        return panel;
    }
}
