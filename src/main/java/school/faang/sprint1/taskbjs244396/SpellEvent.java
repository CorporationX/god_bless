package school.faang.sprint1.taskbjs244396;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;
    
    public SpellEvent(int id, String eventType, String action) {
        validatedInput(id, eventType, action);
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    private void validatedInput(int id, String eventType, String action) {
        if (id < 1) {
            throw new IllegalArgumentException("id must be more than 0");
        }
        if (eventType == null && eventType.isBlank()) {
            throw new IllegalArgumentException("eventType mustn't be empty");
        }
        if (action == null && action.isBlank()) {
            throw new IllegalArgumentException("action mustn't be empty");
        }
    }
}