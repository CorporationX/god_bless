package faang.school.godbless.meta_universe;

import lombok.Getter;

@Getter
public class Notification {

    private String type;
    private String message;

    public Notification(String type, String message) {
        this.type = type.toLowerCase();
        this.message = message;
    }
}
