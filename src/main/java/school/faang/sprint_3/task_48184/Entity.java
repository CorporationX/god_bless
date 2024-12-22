package school.faang.sprint_3.task_48184;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class Entity {
    private final String name;
    private final Location location;
}
