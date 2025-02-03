package school.faang;

import lombok.Getter;

import java.util.Objects;

@Getter
public class SpellEvent {
    private final int id;
    private static int uniqueId = 1;
    private final String eventType;
    private final String action;

    private void validateAction(String action) {
        if (action == null) {
            throw new IllegalArgumentException("action can't be null");
        }
    }

    private void validateEventType(String eventType) {
        if (eventType == null) {
            throw new IllegalArgumentException("eventType can't be null");
        }
    }

    public SpellEvent(String eventType, String action) {
        validateAction(action);
        validateEventType(eventType);
        this.action = action;
        this.eventType = eventType;
        this.id = uniqueId++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpellEvent that = (SpellEvent) o;
        return id == that.id && Objects.equals(eventType, that.eventType) && Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, action);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SpellEvent{");
        sb.append("id=").append(id);
        sb.append(", eventType='").append(eventType).append('\'');
        sb.append(", action='").append(action).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
