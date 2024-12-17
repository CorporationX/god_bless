package school.faang.sprint2task46878;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private final NotificationTyp type;
    private String message;
}