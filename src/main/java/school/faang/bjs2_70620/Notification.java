package school.faang.bjs2_70620;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Notification {
    private final NotificationType notificationType;
    private final String message;
}