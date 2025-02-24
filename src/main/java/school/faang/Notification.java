package school.faang;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Notification {
    private final int id;
    private final String message;
}
