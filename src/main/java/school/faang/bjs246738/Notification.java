package school.faang.bjs246738;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Notification {
    private final Enum<Enums.NotificationType> type;
    private final String message;
}
