package school.faang.task_46917;

import lombok.Getter;

@Getter
public class Notification {
    private String type;
    private String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }

}
