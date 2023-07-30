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
    private GameOfLIfe gameOfLIfe;
    private GridPanel gridPanel;
    private int counter = 0;

    protected  void initGameOfLifeAndGridPanel(GameOfLIfe theGOL, GridPanel theGridPanel){
        gameOfLIfe = theGOL;
        gridPanel = theGridPanel;
    }
    protected void newPatternAction(ActionEvent actionEvent) {
        gameOfLIfe.clear();
        gridPanel.draw();
        for (int i = 0; i < gameOfLIfe.getRows(); i++) {
            for (int j = 0; j < gameOfLIfe.getCols(); j++) {
                Random random = new Random();
                int randomNumber = random.nextInt(500);
                if (randomNumber % 2 == 0){
                    gameOfLIfe.setAlive(i, j);
                    gridPanel.draw();
                }
            }
        }
    }

    protected void stepAction(ActionEvent actionEvent) {
        if (counter == 0) {
            gameOfLIfe.savePattern();
        }
        gameOfLIfe.step();
        gridPanel.draw();
        counter++;
    }

    protected void clearAction(ActionEvent actionEvent) {
        gameOfLIfe.clear();
        gridPanel.draw();
    }

    protected void startAction(ActionEvent actionEvent) {
        gameOfLIfe.savePattern();
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                gameOfLIfe.step();
                gridPanel.draw();
            }
        };
        // Schedule the task to run every second (100 milliseconds)
        timer.scheduleAtFixedRate(task, 0, 100);
    }

    protected void stopAction(ActionEvent actionEvent) {
        timer.cancel();
    }

    public void resetAction(ActionEvent actionEvent) {
        gameOfLIfe.revertToLastSavedVersion();
        gridPanel.draw();
        counter = 0;
    }
}
