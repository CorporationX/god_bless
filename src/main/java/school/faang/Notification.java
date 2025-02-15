package school.faang;

class Notification {

    public enum NotificationType {
        EMAIL, SMS, PUSH
    }

    private NotificationType type;
    private String message;


    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

}
