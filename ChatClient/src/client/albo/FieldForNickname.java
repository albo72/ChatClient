package client.albo;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FieldForNickname {
    private final JTextField fieldForNickname = new JTextField("Nickname");

    public void createFieldSettings(){
        final int[] count = {0};
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

    public JTextField getFieldForNickname() {
        return fieldForNickname;
    }
}
