package bjs2_61828;

public class Notification {
    private final int id;
    private final String message;

    public Notification(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
