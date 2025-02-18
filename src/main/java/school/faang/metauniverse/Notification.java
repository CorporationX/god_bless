package school.faang.metauniverse;

import lombok.Getter;

@Getter
public class Notification {

    public static class NotificationType {
        public static final String EMAIL = "EMAIL";
        public static final String PUSH = "PUSH";
        public static final String SMS = "SMS";

        NotificationType(){
        }
    }

    private final String type;
    private final String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{type=" + type + ", message= " + message + "}";
    }
}
