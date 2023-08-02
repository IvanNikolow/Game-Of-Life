package app;

import enums.State;

public class GameOfLifeCell {
    private State state;

    public GameOfLifeCell() {
    }

    public GameOfLifeCell(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isAlive() {
        return getState().equals(State.ALIVE);
    }
}
