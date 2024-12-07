package school.faang.sprint1.task_44561;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
}