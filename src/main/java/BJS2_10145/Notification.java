package BJS2_10145;

public class Notification {
    String type;
    String message;
    Notification(String type, String message){
        this.message = message;
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
