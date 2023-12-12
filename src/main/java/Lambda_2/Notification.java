package Lambda_2;

public class Notification {

    private String type;
    private String message;

    public Notification(String type, String message) {
        if ((type != null) && (message != null) && (!type.isBlank()) && (!message.isBlank())) {
            this.type = type;
            this.message = message;
        }
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
