package school.faang;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class SpellEvent {
    private final int id;
    private static int uniqueId = 1;
    private final String eventType;
    private final String action;

    private void validateAction(String action) {
        if (action == null || action.isBlank()) {
            throw new IllegalArgumentException("action can't be null or blank");
        }
    }

    private void validateEventType(String eventType) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("eventType can't be null or blank");
        }
    }

    public SpellEvent(String eventType, String action) {
        validateAction(action);
        validateEventType(eventType);
        this.action = action;
        this.eventType = eventType;
        this.id = uniqueId++;
    }
}
