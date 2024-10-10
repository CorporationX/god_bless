package school.faang.task212.notifications;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Notification {
    @Getter
    private String type;
    @Getter
    private String message;
}
