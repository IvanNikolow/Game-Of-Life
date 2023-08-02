package org.example;

import app.GameOfLIfe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridPanel extends JPanel {
    private final GameOfLIfe gameOfLIfe;

    public GridPanel(GameOfLIfe gOL) {
        gameOfLIfe = gOL;
        setMinimumSize(new Dimension(600, 600));
        setLayout(new GridLayout(gameOfLIfe.getRows(), gameOfLIfe.getCols()));
        for (int i = 0; i < gameOfLIfe.getRows(); i++) {
            for (int j = 0; j < gameOfLIfe.getCols() ; j++) {
                int row = i;
                int col = j;
                JButton button = new JButton();

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (gameOfLIfe.isAlive(row, col)) {
                            button.setBackground(Color.WHITE);
                            gameOfLIfe.setAlive(row, col);
                        }else {
                            button.setBackground(Color.BLACK);
                            gameOfLIfe.setDead(row, col);
                        }
                    }
                });

                if (gameOfLIfe.isAlive(row, col)){
                    button.setBackground(Color.WHITE);
                }else {
                    button.setBackground(Color.BLACK);
                }
                add(button);
            }
        }
//        this.addMouseMotionListener(new MouseMotionListener() {
//            @Override
//            public void mouseDragged(MouseEvent e) {
//                int count = 0;
//                int x = e.getX();
//                int y = e.getY();
//                System.out.println(x);
//                System.out.println(y);
//                for (int i = 0; i < gameOfLIfe.rows; i++) {
//                    for (int j = 0; j < gameOfLIfe.cols; j++) {
//                        JButton theButton = (JButton) getComponent(count);
//                        if (x >= theButton.getX() && x <= theButton.getX() + theButton.getWidth() && y >= theButton.getY() && y <= theButton.getY() + theButton.getHeight()){
//                            if (gameOfLIfe.isAlive(i, j) == 0){
//                                theButton.setBackground(Color.WHITE);
//                                gameOfLIfe.setAlive(i, j);
//                                gameOfLIfe.init();
//                            }
//                        }
//
//                        count++;
//                    }
//                }
//            }
//
//            @Override
//            public void mouseMoved(MouseEvent e) {
//
//            }
//        });
    }

    public void draw () {
        int count = 0;
        for (int i = 0; i < gameOfLIfe.getRows(); i++) {
            for (int j = 0; j < gameOfLIfe.getCols(); j++) {
                if (gameOfLIfe.isAlive(i, j)){
                    getComponent(count).setBackground(Color.WHITE);
                }else {
                    getComponent(count).setBackground(Color.BLACK);
                }
                count++;
            }
        }
    }

//    @Override
//    public void mouseDragged(MouseEvent e) {
//        int count = 0;
//        int x = e.getX();
//        int y = e.getY();
//        System.out.println(x);
//        System.out.println(y);
//        for (int i = 0; i < gameOfLIfe.rows; i++) {
//            for (int j = 0; j < gameOfLIfe.cols; j++) {
//                JButton theButton = (JButton) getComponent(count);
//                if (x >= theButton.getX() && x <= theButton.getX() + theButton.getWidth() && y >= theButton.getY() && y <= theButton.getY() + theButton.getHeight()){
//                    if (gameOfLIfe.isAlive(i, j) == 0){
//                        theButton.setBackground(Color.WHITE);
//                        gameOfLIfe.setAlive(i, j);
//                        gameOfLIfe.init();
//                    }
//                }
//
//                count++;
//            }
//        }
//    }
//
//    @Override
//    public void mouseMoved(MouseEvent e) {
//        System.out.println(e.getX());
//    }
}