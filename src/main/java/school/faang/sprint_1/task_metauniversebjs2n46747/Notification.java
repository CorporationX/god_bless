package school.faang.sprint_1.task_metauniversebjs2n46747;

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
