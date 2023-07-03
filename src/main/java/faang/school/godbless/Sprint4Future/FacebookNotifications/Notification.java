package faang.school.godbless.Sprint4Future.FacebookNotifications;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class Notification {
    private static int id = 0;
    private String message;

    public Notification(String message) {
        this.message = message;
        id++;
    }
}
