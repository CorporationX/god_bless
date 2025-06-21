package school.faang.metauniverse;
enum NotifType {
    EMAIL, SMS, PUSH
}

public class Notification {
    NotifType type;
    String text;

    Notification(NotifType type, String text){
        this.type = type;
        this.text = text;
    }

}
