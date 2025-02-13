package school.faang.metaUniverse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@NonNull
public class Notification {
    private final NotificationType type;
    private final String message;
}
