package school.faang.task_57162;

import lombok.Getter;

import java.util.Objects;

@Getter
public class SpellEvent {
    private static final String SPELL_EVENT_INFORMATION = "{id: %d, event type: %s, action: %s}";

    private final Integer id;
    private final String eventType;
    private final String action;

    private static int counter = 1;

    public SpellEvent(String eventType, String action) {
        this.eventType = eventType;
        this.action = action;
        id = counter++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpellEvent that = (SpellEvent) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return String.format(SPELL_EVENT_INFORMATION, getId(), getEventType(), getAction());
    }
}
