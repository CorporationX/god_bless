package faang.school.godbless.metauniverse;


public class Notification {
    private final String type;
    private final String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
