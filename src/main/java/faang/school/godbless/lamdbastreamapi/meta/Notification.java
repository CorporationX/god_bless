package faang.school.godbless.lamdbastreamapi.meta;

public class Notification {
    public  String type;
    public String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public Notification() {
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

}
