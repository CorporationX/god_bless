package faang.school.godbless.MetaUniverse;

public class Notification {
    String type;
    String message;

    public String getMessage() {
        return message;
    }

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
