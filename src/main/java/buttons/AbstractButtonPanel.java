package buttons;

import app.GameOfLIfe;
import org.example.GridPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public abstract class AbstractButtonPanel extends JPanel {
    private Timer timer;
    private final GameOfLIfe gOL;
    private final GridPanel theGridPanel;
    private int counter = 0;

    public AbstractButtonPanel(GameOfLIfe gameOfLIfe, GridPanel gridPanel) {
        this.gOL = gameOfLIfe;
        this.theGridPanel = gridPanel;
    }

    protected void newPatternAction(ActionEvent actionEvent) {
        gOL.clear();
        theGridPanel.draw();
        for (int i = 0; i < gOL.getRows(); i++) {
            for (int j = 0; j < gOL.getCols(); j++) {
                Random random = new Random();
                int randomNumber = random.nextInt(500);
                if (randomNumber % 2 == 0){
                    gOL.setAlive(i, j);
                    theGridPanel.draw();
                }
            }
        }
    }

    protected void stepAction(ActionEvent actionEvent) {
        if (counter == 0) {
            gOL.savePattern();
        }
        gOL.step();
        theGridPanel.draw();
        counter++;
    }

    protected void clearAction(ActionEvent actionEvent) {
        gOL.clear();
        theGridPanel.draw();
    }

    protected void startAction(ActionEvent actionEvent) {
        gOL.savePattern();
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                gOL.step();
                theGridPanel.draw();
            }
        };
        // Schedule the task to run every second (100 milliseconds)
        timer.scheduleAtFixedRate(task, 0, 100);
    }

    protected void stopAction(ActionEvent actionEvent) {
        timer.cancel();
    }

    public void resetAction(ActionEvent actionEvent) {
        gOL.revertToLastSavedVersion();
        theGridPanel.draw();
        counter = 0;
    }
}
