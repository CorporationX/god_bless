package school.faang.catchingevent;

import lombok.Getter;

import java.util.Objects;

@Getter
public class SpellEvent {
    private final int id;
    private final String eventType;
    private final String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
        this.action = action;
    }

    @Override
    public String toString() {
        return String.format("SpellEvent {id=%d, eventType='%s', action='%s'}",
                id, eventType, action);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SpellEvent that = (SpellEvent) o;
        return id == that.id
                && Objects.equals(eventType, that.eventType)
                && Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventType, action);
    }
}
