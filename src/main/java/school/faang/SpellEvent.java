package school.faang;

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
        validateAction(action);
        validateEventType(eventType);
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    public void validateAction(String action) {
        if (action == null || action.isEmpty()) {
            throw new IllegalArgumentException("action cannot be null or blank");
        }
    }

    public void validateEventType(String eventType) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("eventType cannot be null or blank");
        }
    }

}
