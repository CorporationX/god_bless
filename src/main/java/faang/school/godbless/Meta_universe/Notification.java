package faang.school.godbless.Meta_universe;

public class Notification {
    private final String type;
    private final String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
