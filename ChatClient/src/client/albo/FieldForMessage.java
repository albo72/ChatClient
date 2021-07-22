package client.albo;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FieldForMessage {
    private final JTextField fieldForMessage = new JTextField("Enter your message");

    public void createFieldSettings(){
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

    public JTextField getFieldForMessage() {
        return fieldForMessage;
    }
}
