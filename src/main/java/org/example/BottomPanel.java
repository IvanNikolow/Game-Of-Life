package org.example;

import javax.swing.*;
import java.awt.*;

public class BottomPanel extends JPanel{

    public static final String CREATOR = "Ivan Nikolov";
    JLabel createdBy;
    JLabel creator;
    public BottomPanel() {
        setBackground(Color.CYAN);
        createdBy = new JLabel("Created by:");
        creator = new JLabel(CREATOR);

        add(createdBy, BOTTOM_ALIGNMENT);
        add(creator);
    }
}
