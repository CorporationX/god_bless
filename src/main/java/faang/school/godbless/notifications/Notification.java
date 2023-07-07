package faang.school.godbless.notifications;

import lombok.Data;

@Data
public class Notification {
    private static int counter;
    private int id = counter;
    private String message;

    public Notification(String message) {
        counter++;
        this.message = message;
    }
}
