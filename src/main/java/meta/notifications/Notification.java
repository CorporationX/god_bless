package meta.notifications;

public class Notification {
    private final String type;
    private final String message;

    public Notification(String type, String message) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Необходимо задать тип оповещения");
        }
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Необходимо заполнить поле Сообщение");
        }

        this.type = type;
        this.message = message;
    }

    public String getType() {
        return this.type;
    }

    public String getMessage() {
        return this.message;
    }
}
