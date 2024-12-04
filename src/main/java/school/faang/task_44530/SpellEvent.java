package school.faang.task_44530;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpellEvent {
    private final int id;
    private final String eventType;
    private String actionDescription;

}
