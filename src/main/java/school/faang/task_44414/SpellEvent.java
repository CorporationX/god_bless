package school.faang.task_44414;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class SpellEvent {
    private final int id;
    @Getter
    private final String eventType;
    private final String description;
}
