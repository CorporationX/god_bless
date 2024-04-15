package faang.school.godbless.metauniverse;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Notification {
    private final String type;
    private final String message;
}
