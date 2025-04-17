package school.faang.stream2.metauniverse;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Notification {
    private final NotificationType type;
    private final String message;
}
