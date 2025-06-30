package school.faang.bjs2_79163;

public enum GameMessage {
    DAMAGE("Урон: %s");

    private final String message;

    GameMessage(String text) {
        this.message = text;
    }

    @Override
    public String toString() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
