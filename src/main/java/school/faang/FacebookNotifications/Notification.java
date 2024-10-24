package school.faang.FacebookNotifications;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Notification {
    private final int id;
    private final String message;
}
