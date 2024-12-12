package school.faang.meta.universe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Notification {
    private final String type;
    private final String message;

}
