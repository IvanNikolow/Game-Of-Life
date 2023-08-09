package app;

import app.enums.State;

public class GameOfLIfe {
    int rows;
    int cols;
    GameOfLifeCell[][] cellGrid;
    GameOfLIfe newVersion;
    GameOfLIfe resetVersion;

    public GameOfLIfe(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        cellGrid = new GameOfLifeCell[rows][cols];
        initCellGrid();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setAlive(int row, int col){
        cellGrid[row][col].setState(State.ALIVE);
    }

    public void setDead(int row, int col){
        cellGrid[row][col].setState(State.DEAD);
    }

    public boolean isAlive(int row, int col) {
        return cellGrid[row][col].isAlive();
    }

    public GameOfLIfe step() {
        newVersion = this;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int counted = countAliveNeighbours(i, j);
                if (isAlive(i, j)) {
                    if (counted < 2){
                        newVersion.setDead(i, j);
                    } else if (counted == 2 || counted == 3) {
                        // do nothing
                    }else {
                        newVersion.setDead(i, j);
                    }
                }else {
                    if (counted == 3){
                        newVersion.setAlive(i, j);
                    }
                }
            }
        }
        return newVersion;
    }

    public int countAliveNeighbours (int row, int col){
        int counter = 0;

        counter += getCellValue(row - 1, col - 1);
        counter += getCellValue(row, col - 1);
        counter += getCellValue(row + 1, col - 1);

        counter += getCellValue(row - 1, col);
        counter += getCellValue(row + 1, col);

        counter += getCellValue(row - 1, col + 1);
        counter += getCellValue(row, col + 1);
        counter += getCellValue(row + 1, col + 1);

        return counter;
    }

    public int getCellValue(int row, int col) {
        if (row < 0 || row >= rows) {
            return 0;
        } else if (col < 0 || col >= cols) {
            return 0;
        }
        return cellGrid[row][col].getState().getValue();
    }

    public void clear() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                setDead(i, j);
            }
        }
    }

    public void initCellGrid() {
        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < cols; j++) {
                if(cellGrid[i][j] == null){
                    cellGrid[i][j] = new GameOfLifeCell(State.DEAD);
                }
            }
        }
    }

    public void savePattern() {
        resetVersion = new GameOfLIfe(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!isAlive(i, j)){
                    resetVersion.setAlive(i, j);
                }else {
                    resetVersion.setDead(i, j);
                }
            }
        }
    }

    public void revertToLastSavedVersion(){
        this.clear();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!resetVersion.isAlive(i, j)){
                    this.setAlive(i, j);
                }else {
                    this.setDead(i, j);
                }
            }
        }
    }
}

