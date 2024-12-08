package school.faang.meta_universe;

import lombok.RequiredArgsConstructor;
import lombok.Getter;

@Getter
@RequiredArgsConstructor
public class Notification {
    private final String type;
    private final String message;
}
