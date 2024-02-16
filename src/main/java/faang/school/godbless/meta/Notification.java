package faang.school.godbless.meta;

import lombok.Getter;

@Getter
public class Notification {
    String type;
    String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}