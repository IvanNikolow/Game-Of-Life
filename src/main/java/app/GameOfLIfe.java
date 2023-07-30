package app;

public class GameOfLIfe {
    int rows;
    int cols;
    int[][] grid;
    GameOfLIfe newVersion;
    GameOfLIfe resetVersion;

    public GameOfLIfe(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new int[rows][cols];
        init();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setAlive(int row, int col){
        grid[row][col] = 1;
    }

    public void setDead(int row, int col){
        grid[row][col] = 0;
    }

    public int isAlive(int row, int col){
        if (row < 0 || row >= rows){
            return 0;
        }else if (col < 0 || col >= cols){
            return 0;
        }
        return grid[row][col];
    }



    public GameOfLIfe step() {
        newVersion = this;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int counted = countAliveNeighbours(i, j);
                if (isAlive(i, j) == 1) {
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

            counter += isAlive(row - 1, col - 1);
            counter += isAlive(row, col - 1);
            counter += isAlive(row + 1, col - 1);

            counter += isAlive(row - 1, col);
            counter += isAlive(row + 1, col);

            counter += isAlive(row - 1, col + 1);
            counter += isAlive(row, col + 1);
            counter += isAlive(row + 1, col + 1);

            return counter;
        }

    public void clear() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                setDead(i, j);
            }
        }
    }

    @Deprecated
    public void init() {
        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("*");
                } else if (grid[i][j] == 1) {
                    System.out.print(".");
                }
            }
        }
    }

    public void savePattern() {
        resetVersion = new GameOfLIfe(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isAlive(i, j) == 1){
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
                if (resetVersion.isAlive(i, j) == 1){
                    this.setAlive(i, j);
                }else {
                    this.setDead(i, j);
                }
            }
        }
    }
}

