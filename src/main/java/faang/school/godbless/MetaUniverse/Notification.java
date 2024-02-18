package faang.school.godbless.MetaUniverse;

import lombok.Getter;

@Getter
public class Notification {
    private String type,message;

    public Notification(String type, String message) {
        this.message=message;
        this.type=type;
    }
}
