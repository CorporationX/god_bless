package faang.school.godbless.meta;

import lombok.Getter;


public class Notification {
    private String type;
    private String message;

    public Notification(String type, String massage) {
        this.type = type;
        this.message = massage;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

}
