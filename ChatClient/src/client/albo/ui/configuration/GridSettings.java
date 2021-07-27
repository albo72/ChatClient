package client.albo.ui.configuration;

import java.awt.*;

public class GridSettings {

    public void changeGridSettings(GridBagConstraints gridBagConstraints, int i, int i2, double v, int i3, int i4) {
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        gridBagConstraints.gridx = i;
        gridBagConstraints.gridy = i2;
        gridBagConstraints.weightx = v;
        gridBagConstraints.gridheight = i3;
        gridBagConstraints.ipady = i4;
    }
}
