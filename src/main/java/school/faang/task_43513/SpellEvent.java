package school.faang.task_43513;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpellEvent {
    private int id;
    private EventType eventType;
    private String action;
}
