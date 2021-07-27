package client.albo.ui.configuration;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ConfigurationOfFieldForMessage {

    public void configurate(JTextField fieldForMessage){
        fieldForMessage.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                fieldForMessage.setText(null);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (fieldForMessage.getText().trim().isEmpty()){
                    fieldForMessage.setText("Enter your message");
                }
            }
        });
    }
}
