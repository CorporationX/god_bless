package school.faang.task44690.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpellEvent {
    private final Integer id;
    private final String eventType;
    private final String action;
}
