package school.module1.task44498;

import java.util.Objects;

public class SpellEvent {
    private int id;
    private String eventType;
    private String action;

    public SpellEvent(int id, String eventType, String action) {
        this.id = id;
        this.eventType = eventType;
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
}
