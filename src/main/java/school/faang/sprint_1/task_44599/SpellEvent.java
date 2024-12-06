package school.faang.sprint_1.task_44599;

import lombok.Getter;

import java.util.Objects;

@Getter
public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        if (eventType.isEmpty()) {
            throw new IllegalArgumentException("EventType cannot be null or empty");
        }
        this.eventType = eventType;
        if (action.isEmpty()) {
            throw new IllegalArgumentException("Action cannot be null or empty");
        }
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
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
        return "SpellEvent id: " + id
                + ", eventType: '" + eventType
                + "', action: '" + action + "'";
    }
}