package faang.school.godbless.metaworld;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Notification {
    private NotificationType type;
    private String message;
}
