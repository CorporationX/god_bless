package school.faang.sprint_2.meta_universe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Notification {
    private final String type;
    private final String message;
}
