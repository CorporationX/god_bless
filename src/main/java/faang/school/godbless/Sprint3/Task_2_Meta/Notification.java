package faang.school.godbless.Sprint3.Task_2_Meta;

public class Notification {
    private String type;
    private String message;

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
