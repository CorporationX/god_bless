package school.faang.naughtwoBJS257232;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(int id, String eventType, String action) {
        if (eventType.isBlank()
                || action.isBlank()) {
            throw new IllegalArgumentException("Incorrect data entered");
        }
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    @Override
    public String toString() {
        return String.format("Spell event %d type '%s', action - '%s'",
                this.getId(), this.getEventType(), this.getAction());
    }
}
