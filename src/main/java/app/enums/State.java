package app.enums;

public enum State {
    DEAD(0),
    ALIVE(1);
    private final int value;

    State(int stateValue) {
        value = stateValue;
    }

    public int getValue() {
        return value;
    }
}
