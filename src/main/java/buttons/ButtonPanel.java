package buttons;

import app.GameOfLIfe;
import org.example.GridPanel;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends AbstractButtonPanel{

    private JButton pressButton, resetButton, startButton, stopButton, newPattern, clearButton;

    public ButtonPanel(GameOfLIfe gOL, GridPanel theGrid) {
        initGameOfLifeAndGridPanel(gOL, theGrid);
        setLayout(new GridLayout(4, 4));
//        setMinimumSize(new Dimension(200, 200));

        pressButton = new JButton("Step!");
        pressButton.addActionListener(this::stepAction);

        resetButton = new JButton("Reset!");
        resetButton.addActionListener(this::resetAction);

        startButton = new JButton("Start!");
        startButton.addActionListener(this::startAction);

        stopButton = new JButton("Stop!");
        stopButton.addActionListener(this::stopAction);

        newPattern = new JButton("Pattern!");
        newPattern.addActionListener(this::newPatternAction);

        clearButton = new JButton("Clear!");
        clearButton.addActionListener(this::clearAction);

        add(pressButton);
        add(resetButton);
        add(startButton);
        add(stopButton);
        add(newPattern);
        add(clearButton);
    }
}
