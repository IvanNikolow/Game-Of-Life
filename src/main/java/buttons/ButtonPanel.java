package buttons;

import app.GameOfLIfe;
import org.example.GridPanel;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends AbstractButtonPanel{


    public ButtonPanel(GameOfLIfe gOL, GridPanel theGrid) {
        super(gOL, theGrid);
        setLayout(new GridLayout(3, 3));

        JButton pressButton = new JButton("Step!");
        pressButton.addActionListener(this::stepAction);

        JButton resetButton = new JButton("Reset!");
        resetButton.addActionListener(this::resetAction);

        JButton startButton = new JButton("Start!");
        startButton.addActionListener(this::startAction);

        JButton stopButton = new JButton("Stop!");
        stopButton.addActionListener(this::stopAction);

        JButton newPattern = new JButton("Pattern!");
        newPattern.addActionListener(this::newPatternAction);

        JButton clearButton = new JButton("Clear!");
        clearButton.addActionListener(this::clearAction);

        add(pressButton);
        add(resetButton);
        add(startButton);
        add(stopButton);
        add(newPattern);
        add(clearButton);
    }
}
