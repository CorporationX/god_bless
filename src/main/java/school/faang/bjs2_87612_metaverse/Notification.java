package school.faang.bjs2_87612_metaverse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private NotificationType notificationType;
    private String message;
}