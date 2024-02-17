package BJS2_2708;

public class Notification {
    private String type;
    private String message;

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }

}


