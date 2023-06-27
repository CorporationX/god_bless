package faang.school.godbless.sprint_3.task_2;

import lombok.Data;

@Data
public class Notification {
    private String type;
    private String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
