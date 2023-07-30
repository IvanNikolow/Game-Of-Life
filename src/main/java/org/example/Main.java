package org.example;

import app.GameOfLIfe;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        GameOfLIfe gOL = new GameOfLIfe(15, 15);
        MainVisualisationPanel bV = new MainVisualisationPanel(gOL);
    }
}