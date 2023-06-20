package faang.school.godbless.meta.model;

public class Notification {
    private String type;
    private String message;

    public Notification() {
    }

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
