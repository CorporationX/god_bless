package school.faang.second_sprint.googlemaps.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private NotificationType notificationType;
    private String message;
}
