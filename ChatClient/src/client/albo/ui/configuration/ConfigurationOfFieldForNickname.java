package client.albo.ui.configuration;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ConfigurationOfFieldForNickname {

    public void configurate(JTextField fieldForNickname){
        fieldForNickname.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (fieldForNickname.isEditable()){
                    fieldForNickname.setText(null);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
    }
}
