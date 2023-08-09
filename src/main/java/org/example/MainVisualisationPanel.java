package org.example;

import app.GameOfLIfe;
import buttons.ButtonPanel;

import javax.swing.*;
import java.awt.*;
//TASK: Add descriptions
public class MainVisualisationPanel extends JFrame{


    JSplitPane mainSplitPane;
    JSplitPane secondSplitPane;

    public MainVisualisationPanel(GameOfLIfe gOL) {
        setTitle("Game of Life!");
        setSize(800, 600);

        mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mainSplitPane.setDividerLocation(600);

        GridPanel theGrid = new GridPanel(gOL);
        mainSplitPane.setLeftComponent(theGrid);

        secondSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        secondSplitPane.setDividerLocation(200);
        secondSplitPane.setTopComponent(new ButtonPanel(gOL, theGrid));
        secondSplitPane.setBottomComponent(new BottomPanel());
        
        mainSplitPane.setRightComponent(secondSplitPane);

        add(mainSplitPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
