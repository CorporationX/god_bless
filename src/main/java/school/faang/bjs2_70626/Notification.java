package school.faang.bjs2_70626;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
class Notification {
    private final NotificationType notificationType;
    private final String message;
}
